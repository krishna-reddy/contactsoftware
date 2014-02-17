package com.adaptavant.counter.service.sharedcounter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import com.google.appengine.api.urlfetch.URLFetchService;


@Service
public class SharedCounterService {
	/**
     * A logger object.
     */
    private static final Logger LOG = Logger.getLogger(SharedCounterService.class
            .getName());
	/**
	 * Declare a URL object
	 */
	private URL url=null;
	/**
	 * Declare a HttpURLConnection object.
	 */
	private HttpURLConnection con=null;
	/**
	 * Create a entry for newly counting a records.
	 */
	public int createEntry(String pid,String cname)
			throws IOException {
	
		//initialize the count
		int count=-1;
		try {
			
		//create the JSON object
		JSONObject json=new JSONObject();
		
		//initialize the url
		String urlvalue= "http://sharding-service.appspot.com/sharedcounter/createCounterEntry";
		
		//set the value into json
		json.put("projectIdentity",pid);
		json.put("counterName", cname);
		
		//create the new URL.
		url = new URL(urlvalue);
		
		//open the url connection i.e actual connection made with remote object.
		con =(HttpURLConnection)url.openConnection();
		
		//set the post method
		con.setRequestMethod("POST");
		
		//set the MIME type
		con.setRequestProperty("Content-Type","application/json");
		
		//set the redirect to false
		con.setInstanceFollowRedirects(false);
		
		//set the output to true
		con.setDoOutput(true);
		
		//get the dataoutput stream for writing string data.
		DataOutputStream dout= new DataOutputStream(con.getOutputStream());
		//writes the the json string into outputstream
		dout.writeBytes(json.toString());
		//flush the data
		dout.flush();
		//close the stream
		dout.close();
		
		//get the Json tokener
		JSONTokener jt=new JSONTokener(new InputStreamReader(con.getInputStream()));
		
		//get the json object by passing jsontokener
		json = new JSONObject(jt);
		
		//get the counterName from json
		String counterName=json.getString("counterName");
		
		if(!counterName.equals("Invalid")){
			count=json.getInt("count");
		}
		} catch (JSONException e) {
			//log error message here
			LOG.log(Level.WARNING, e.toString(), e);
			
		}
		//return the count value
		return count;		
		
	}
	
	/**
	 * Update the counter entry.
	 */
	public int updateEntry(String pid,String cname)
			throws IOException {
		//initialize the counter
		int count=-1;
		try{
		//create the JSON object	
		JSONObject json=new JSONObject();
		
		//create the url
		String urlvalue= "http://sharding-service.appspot.com/sharedcounter/updateCounterEntry";
		
		
		//set the value into json
		json.put("projectIdentity",pid);
		json.put("counterName", cname);
		
		//create the new URL
		url = new URL(urlvalue);
		
		//make the connection to the remote object.
		con =(HttpURLConnection)url.openConnection();
		
		//set the post method request
		con.setRequestMethod("POST");
		
		//set the MIME type as application/json
		con.setRequestProperty("Content-Type","application/json");
		
		//set the redirect to false
		con.setInstanceFollowRedirects(false);
		
		//set the output stream to true
		con.setDoOutput(true);
		
		//get the output stream
		DataOutputStream dout= new DataOutputStream(con.getOutputStream());
		
		//write the json data
		dout.writeBytes(json.toString());
		
		//flush the data
		dout.flush();
		
		//close the stream
		dout.close();
		
		//get the json tokenizer
		JSONTokener jt=new JSONTokener(new InputStreamReader(con.getInputStream()));
		
		//create the json object using tokens.
		json = new JSONObject(jt);
		
		//get the counter name
		String counterName=json.getString("counterName");
		//check the counter name
		if(!counterName.equals("Invalid")){
			//get the count
			count=json.getInt("count");
			return count;
		}
		}catch(Exception e){
			//log the error message
			LOG.log(Level.WARNING, e.toString(), e);
		}
		
	return count;
		
	}
	/**
	 * Delete the counter entry.
	 */
	
	public int deleteEntry(String pid,String cname)
			throws IOException {
		//initialize the count
		int count=-1;
		try{
		//create the new url
		String urlvalue= "http://sharding-service.appspot.com/sharedcounter/deleteCounterEntry";
		//create the json object
		JSONObject json=new JSONObject();
		
		//put the data into json obejct
		json.put("projectIdentity",pid);
		json.put("counterName", cname);
		
		//create the URL
		url = new URL(urlvalue);
		
		//open the connection for remote object
		con =(HttpURLConnection)url.openConnection();
		
		//set the post request
		con.setRequestMethod("POST");
		
		//set the MIME type
		con.setRequestProperty("Content-Type","application/json");
		
		//set the redirect to false
		con.setInstanceFollowRedirects(false);
		
		//set the output to true
		con.setDoOutput(true);
		
		//get the output stream
		DataOutputStream dout= new DataOutputStream(con.getOutputStream());
		
		//write date to stream
		dout.writeBytes(json.toString());
		
		//flush the data to remote object
		dout.flush();
		
		//close the output stream
		dout.close();
		
		//get the json tokenizer
		JSONTokener jt=new JSONTokener(new InputStreamReader(con.getInputStream()));
		
		//create json object by passing tokens
		json = new JSONObject(jt);
		
		//get the counter name
		String counterName=json.getString("counterName");
		//check the counter name
		if(!counterName.equals("Invalid")){
			// get the count
			count=json.getInt("count");
		}
		} catch (Exception e) {
			//log the error message
			LOG.log(Level.WARNING, e.toString(), e);
		}
		
		return count;
	}
	/**
	 * Get the count value
	 */
	public int getCount(String pid)
			throws IOException {
		//initialize the count
		int count=0;
		try{
		 //create the new url 
		String urlvalue= "http://sharding-service.appspot.com/sharedcounter/getCount";
		
		// create the json object
		JSONObject json=new JSONObject();
		
		//put the data into json object
		json.put("projectIdentity",pid);
		
		//create the url
		url = new URL(urlvalue);
		
		//open the connection to remote object
		con =(HttpURLConnection)url.openConnection();
		
		//set the post method
		con.setRequestMethod("POST");
		
		//set the MIME type
		con.setRequestProperty("Content-Type","application/json");
		
		//set the redirect to false
		con.setInstanceFollowRedirects(false);
		
		//set the output to true
		con.setDoOutput(true);
		
		//get the output stream
		DataOutputStream dout= new DataOutputStream(con.getOutputStream());
		//write data to output stream
		dout.writeBytes(json.toString());
		
		//flush the data
		dout.flush();
		
		//close the output stream
		dout.close();
		
		//get the data into JSON tokens
		JSONTokener jt=new JSONTokener(new InputStreamReader(con.getInputStream()));
		
		//create the json object
		json = new JSONObject(jt);
		
		//get the counter name
		String counterName=json.getString("counterName");
		
		//check the countername for invalidate
		if(!counterName.equals("Invalid")){
			//get the count
			count=json.getInt("count");
		}
			
		} catch (Exception e) {
			//log the error message
			LOG.log(Level.WARNING, e.toString(), e);
		}
		
		return count;
	}
	
}
