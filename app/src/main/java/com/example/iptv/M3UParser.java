package com.example.iptv;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class M3UParser {

    private static final String EXT_M3U = "logo=";
    private static final String EXT_INF = "#EXTINF:";

    private static final String EXT_GROUP = "group-title=";
    private static final String EXT_PLAYLIST_NAME = "#PLAYLIST";
    private static final String EXT_LOGO = "tvg-logo";
    private static final String EXT_URL = "http://";

    public String convertStreamToString(InputStream is) {
        try {
            return new Scanner(is).useDelimiter("\\A").next();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public M3U8Playlist parseFile(InputStream inputStream) throws FileNotFoundException {
        M3U8Playlist m3UPlaylist = new M3U8Playlist();
        List<M3U8> playlistItems = new ArrayList<>();
        String stream = convertStreamToString(inputStream);
        String linesArray[] = stream.split(EXT_INF);
       // Log.d("#ref","good");
        for (int i = 1; i < linesArray.length; i++) {
           // Log.d("##","1");
            String currLine = linesArray[i];
           // System.out.println(currLine);
            String logo="/logo.jpg";
            if (currLine.contains(EXT_M3U)) {
                logo = currLine.substring(EXT_M3U.length()+4, currLine.indexOf(EXT_GROUP)-2);
                // System.out.println("!l="+logo);
            }
          //  Log.d("44R","6");

            // System.out.println(currLine.indexOf(EXT_GROUP)+13+"/"+currLine.indexOf(","));
            String group = currLine.substring(currLine.indexOf(EXT_GROUP)+13, currLine.indexOf(",")-1);
            // System.out.println("!g="+group);
            String name = currLine.substring(currLine.indexOf(",")+1, currLine.indexOf("ht")-1);
            // System.out.println("!name="+name);
            String url = currLine.substring( currLine.indexOf("ht"));

            //System.out.println("!url="+url);
            M3U8 m3u8=new M3U8(name,group,logo,url);
           // Log.d("44R","7");
            M3U8Playlist.chanelList.add(m3u8);
           // Log.d("44R","8"+" "+M3U8Playlist.chanelList.size());

        }
        return null;}
}