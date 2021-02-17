/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssc.video;

import api.ServiceAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author PC
 */
public class YoutubeApiVideo {

    private String title;
    private String description;
    private String thumb;
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YoutubeApiVideo(JSONObject opject) {
        title = ((JSONObject) opject.get("snippet")).get("title").toString();
        description = ((JSONObject) opject.get("snippet")).get("description").toString();
        thumb = ((JSONObject) ((JSONObject) ((JSONObject) opject.get("snippet")).get("thumbnails")).get("high")).get("url").toString();
        id = ((JSONObject) opject.get("id")).get("videoId").toString();
    }

    
    public static YoutubeResult getArrVideoFromItems(String jsonResultString) {
        List<YoutubeApiVideo> arr = new ArrayList<>();
        String nextPage="";
        try {
            Object obj = new JSONParser().parse(jsonResultString);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray items = (JSONArray) jsonObject.get("items");
            Iterator i = items.iterator();
            while (i.hasNext()) {
                JSONObject video = (JSONObject) i.next();
                arr.add(new YoutubeApiVideo(video));
            }
            try {
                nextPage=jsonObject.get("nextPageToken").toString();
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new YoutubeResult(arr, nextPage);
    }

    public static List<YoutubeApiVideo> getArrayVideoFromSearchQuery(String query, int minVideo) {
        List<YoutubeApiVideo> arr = new ArrayList<>();
        String url = "";
        String nextPage="";
        do {
            url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=50&q=" + query + "&type=video"
                    + "&key=AIzaSyAStTN9Ldm9tS--vF8lCj_sZqErX-NoIqk&order=viewCount&videoDuration=long"+(nextPage.length()==0?"":"&pageToken="+nextPage);
            String result = ServiceAction.getResultFromAnyAPIJson(url, null);
            YoutubeResult tr=getArrVideoFromItems(result);
            arr.addAll(tr.getArrVideo());
            nextPage=tr.getNextPageToken();
        } while (arr.size() < minVideo&&nextPage.length()!=0);

        return arr;
    }
}
