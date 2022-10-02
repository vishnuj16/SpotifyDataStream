package song_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQueryException;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.from_json;

public class SparkStructuredStreamingWithSongReq {

	public static void main(String[] args) throws TimeoutException, StreamingQueryException{
		
		SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkStructuredStreamingWithKafka");
		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		List<StructField> fields = new ArrayList<StructField>();
		
		
		fields.add(DataTypes.createStructField("songid", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("songname", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("artiste", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("duration", DataTypes.DoubleType, true));
		fields.add(DataTypes.createStructField("Userid", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("Username", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("PhoneNO", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("ReqID", DataTypes.StringType, true));
		
		StructType structType = DataTypes.createStructType(fields);


		Dataset<Row> df = spark
				.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9093, localhost:9094, localhost:9095")
				.option("subscribe", "spotifystream")
				.load();
		
		Dataset<Row> res = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
		.withColumn("value", from_json(col("value"), structType))
		.select(col("value.*"));
		
		res.createOrReplaceTempView("spotifystreaming");
		
		spark.sql("select songid, songname, artiste from spotifystreaming")
		.writeStream()
		.format("console")
		.outputMode(OutputMode.Append())
		.start()
		.awaitTermination();
		
		
	}

}
