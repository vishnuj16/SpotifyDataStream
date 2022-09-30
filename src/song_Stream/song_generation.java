package song_Stream;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import com.google.gson.Gson;


public class song_generation {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		//System.out.println("Hello World!");
		/*File file = new File("songs-info.json");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);*/
		
		//String ID = UUID.randomUUID().toString();
		
		RandDataGen rand = new RandDataGen();
		
		String[] IDS = new String[10];
		for (int i=0; i<10;i++)
		{
			IDS[i] = UUID.randomUUID().toString();
		}
		
		String[] IDSuser = new String[15];
		for (int i=0; i<15;i++)
		{
			IDSuser[i] = UUID.randomUUID().toString();
		}
		
		String[] names = {"Vishnu", "Varsha", "Sreekala", "Jagadeesh", "Sreedevi", "Jitmanyu", "Ashwanth", 
				"Sanjayan", "Vishal", "Shajith", "Vignesh", "Vaishnavi", "Vaishnav", "Sana", "Kashwi", 
				"Hashvitha"};
		String[] phone = new String[15]; 
		
		for (int i=0; i<15 ; i++)
		{
			phone[i] = rand.randomPhoneno();
		}
		
		double[] durations = new double[10];
		durations[0] = 235.564;
		durations[1] = 253.678;
		durations[2] = 212.134;
		durations[3] = 194.987;
		durations[4] = 173.973;
		durations[5] = 234.934;
		durations[6] = 178.817;
		durations[7] = 213.987;
		durations[8] = 215.018;
		durations[9] = 275.812;
	
		
		//si.setSongid(ID);
		
		Map <String, String> sl = new HashMap <String, String>();
		sl.put("Taylor Swift", "Wildest Dreams");
		sl.put("Anirudh", "Thaikelavi");
		sl.put("WCMT", "Khoj");
		sl.put("Alvaro Soler", "La Libertad");
		sl.put("Pritam", "Kesariya");
		sl.put("The Script", "Hall Of Fame");
		sl.put("Alec Benjamin", "Let me Down Slowly");
		sl.put("Anirudh", "Marana Mass");
		sl.put("Yuvan Shankar Raja", "Rendu Raja");
		sl.put("MM Keeravaani", "Naatu Naatu");
		
		while(true)
		{
			song_info si = new song_info();
			user_info ui = new user_info();
			
			int n = sl.size();
			int index = RandDataGen.randIndex(n);
			
			int i=0;
			String Artiste = null, song= null;
			for (Map.Entry mapElement : sl.entrySet()) {
	            Artiste= (String)mapElement.getKey();
	  
	            song= (String)mapElement.getValue();
	  
	            //System.out.println(key + " : "+ value);
	            if (i==index)
	            {
	            	break;
	            }
	            else
	            {
	            	i++;
	            	continue;
	            }
	        }
			si.setArtiste(Artiste);
			si.setSongname(song);
			si.setSongid(IDS[i]);
			si.setDuration(durations[i]);
			
			n = IDSuser.length;
			index = RandDataGen.randIndex(n);
			ui.setUserID(IDSuser[index]);
			ui.setUsername(names[index]);
			ui.setPhoneNO(phone[index]);
			
			songReq sq = new songReq(si,ui);
			
			//Gson gson = new Gson();
			//json = gson.toJson(si);
			System.out.println(new Gson().toJson(sq));
			//bw.write(si.toString()+"\n");
			Thread.sleep(1000);

		}
		
	}

}
