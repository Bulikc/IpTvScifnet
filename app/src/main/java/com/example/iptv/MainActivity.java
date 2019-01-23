package com.example.iptv;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
*/

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

//import static com.google.android.exoplayer2.extractor.ts.TsExtractor.MODE_SINGLE_PMT;


public class MainActivity extends AppCompatActivity {


    //  String stream="android.resource://"+getPackageName()+"/"+R.raw.test;
    Drawable drawable;
    MediaPlayer mediaPlayer;
    boolean prepared=false;
    boolean started=false;
  //  PlayerView playerView;
   // SimpleExoPlayer simpleExoPlayer;
    //

    private SurfaceView surface;

  //  private ExoPlayer player;

    private String video_url;
    private Handler mainHandler;
    private AudioManager am;
    private String userAgent;
    private static final int BUFFER_SEGMENT_SIZE = 64 * 1024;
    private static final int MAIN_BUFFER_SEGMENTS = 254;
    public static final int TYPE_VIDEO = 0;
    RecyclerView rv;
    RVAdapter adapter;
    View Oldview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializePlayer();
       // playerView=findViewById(R.id.vid);
       // DefaultTrackSelector trackSelector = new DefaultTrackSelector();



        // sufaceview = (SurfaceView) findViewById(R.id.surfaceView2);
      //  simpleExoPlayer=ExoPlayerFactory.newSimpleInstance(
        //        new DefaultRenderersFactory(this),
        //        new DefaultTrackSelector(), new DefaultLoadControl());






       // playerView.setPlayer(simpleExoPlayer);

       // DefaultDataSourceFactory dataSourceFactory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"ExoPlayer"));

       // ExtractorMediaSource mediaSource=new ExtractorMediaSource.Factory(dataSourceFactory)
         //       .createMediaSource(Uri.parse("http://185.70.15.1:27999/stream?id=3502"));


      /*   ExtractorMediaSource mediaSource1=new ExtractorMediaSource ( Uri.parse("http://185.70.15.1:27999/stream?id=3502"),
                 dataSourceFactory,
                 ExtractorsFactory  extractorsFactory,
                null,null
         );*/







        //  MediaSource md=new MediaSource(Uri.parse("http://185.70.15.1:27999/stream?id=3502"));
        //   ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();


        //MediaSource videoSource = new HlsMediaSource(Uri.parse("http://185.70.15.1:27999/stream?id=3502"), dataSourceFactory, 1, null, null);


        //mediaSource.
       /*simpleExoPlayer.prepare(mediaSource);
        try {
            //  AudioAttributes audioAttributes=new AudioAttributes();
        simpleExoPlayer.setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(C.USAGE_MEDIA)
                    .setContentType(C.CONTENT_TYPE_MUSIC)
                    .build()
            );

            //   Log.d("lllll", simpleExoPlayer.get;);
        }
        catch(Exception e){
            Log.d("lllll", e.getMessage());
        }*/


        // TrackGroupArray trg=simpleExoPlayer.getCurrentTrackGroups();
        // Log.d("tagiv",trg.length+"");
        //simpleExoPlaet
        // simpleExoPlayer.setShuffleModeEnabled(false);
        // simpleExoPlayer.setVolume(100);
        // simpleExoPlayer.setRepeatMode(Player.REPEAT_MODE_OFF);
        //simpleExoPlayer.setPlayWhenReady(true);
        //   mediaPlayer=new MediaPlayer();
        // mediaPlayer.stre

      /*  new PlayerTasc().execute(stream);


        mediaPlayer.start();*/
         createDefoutl();



    }


    private void initializePlayer(){
        // Create a default TrackSelector
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);

        //Initialize the player
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        //Initialize simpleExoPlayerView
        SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.exoplayer);
        simpleExoPlayerView.setPlayer(player);
        simpleExoPlayerView.setUseController(false);
        simpleExoPlayerView.hideController();
        simpleExoPlayerView.
        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(this, Util.getUserAgent(this, "CloudinaryExoplayer"));

        // Produces Extractor instances for parsing the media data.
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        // This is the MediaSource representing the media to be played.
        Uri videoUri = Uri.parse("http://185.70.15.1:27999/stream?id=3508");
        MediaSource videoSource = new ExtractorMediaSource(videoUri,
                dataSourceFactory, extractorsFactory, null, null);

        // Prepare the player with the source.
        player.prepare(videoSource);
        player.setPlayWhenReady(true);
    }

    class Person {
        String name;
        String age;
        int photoId;

        Person(String name, String age, int photoId) {
            this.name = name;
            this.age = age;
            this.photoId = photoId;
        }
    }

    private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){


        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher_background));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher_background));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher_background));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher_background));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher_background));
    }






    private static List<Chanel> chanel;
    private static List<Chanel> l;
    private static List<String> li;


    public void selectedCnanel(View view,int position){
        drawable=view.getBackground();
        view.setBackgroundColor(Color.YELLOW);
        int indexCount=adapter.getItemCount();
        Log.d("ddddd",adapter.getItemCount()+"");

        if(Oldview!=null)
        Oldview.setBackground(drawable);
        id=position;
        Oldview=view;
    }


    private static  InputStream downloadUsingStream(String url) {

// Send data

        Uri vidUri = Uri.parse("http://185.70.15.1:27999/play");

        BackFLoaderActivity bl=new BackFLoaderActivity();
        new AsyncTask<String, Integer, ArrayList<M3U8>>() {
            private Exception m_error = null;



            @Override
            protected  ArrayList<M3U8> doInBackground(String... params) {

                try {
                    //  Log.d("44R","2");
                    URL url  = new URL("http://185.70.15.1:27999/play");

                    // vidUri.describeContents()
                    URLConnection conn =  url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    //  Log.d("44R","3");
                    wr.flush();
                    M3UParser m3u8=new M3UParser();
                    //   Log.d("44R","4");
                    m3u8.parseFile(conn.getInputStream());
                    //   Log.d("44R","5");

                    chanel = new ArrayList<Chanel>();

                    for(M3U8 m: M3U8Playlist.chanelList){
                        chanel.add(new Chanel(m.getName(),m.getGroup(),m.getGroup(),R.drawable.ic_launcher_background));

                    }
                    //chanel.add(new Chanel(M3U8Playlist.chanelList.size()+"","10-00","peredacha",R.drawable.ic_launcher_background));
                    // chanel.add(new Chanel("kanal","10-00","peredacha",R.drawable.ic_launcher_background));
                    // chanel.add(new Chanel("kanal","10-00","peredacha",R.drawable.ic_launcher_background));




                    return  M3U8Playlist.chanelList;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    m_error = e;
                } catch (IOException e) {
                    e.printStackTrace();
                    m_error = e;
                }

                return M3U8Playlist.chanelList;
            }


        }.execute(url);








        return null;
    }

    int id=-1;

    RecyclerView list;
    private void createDefoutl(){

        // String url="http://162.243.116.249/orsha/orsha.xml";
        // String url="http://162.243.116.249/orsha/orsha.xml";
        list = (RecyclerView) findViewById(R.id.list);
        Log.d("44R","8"+" "+M3U8Playlist.chanelList.size());

        String vidAddress = "http://185.70.15.1:27999/stream?id=3491";
        //http://185.70.15.1:27999/play
      // exoPlayer = ExoPlayer.Factory.newInstance(2);
      //  exoPlayer.


        Log.d("44R","8"+" "+M3U8Playlist.chanelList.size());

       rv=(RecyclerView)findViewById(R.id.rv);
        //recyclerView1.add



        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rv ,new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("tapitapi",position+"");
                        ListAdapter adapter;
                        if(id!=position){
                        switch (position){
                            case 0:  adapter = new ListAdapter(List1.l);
                                list.setAdapter(adapter);
                                list.scrollToPosition(7);


                                selectedCnanel(view,position);


                               // view.setBackgroundColor(14);
                                break;
                            case 1:  adapter = new ListAdapter(List1.l2);
                                list.setAdapter(adapter);

                                selectedCnanel(view,position);

                                break;
                            case 2:  adapter = new ListAdapter(List1.l3);
                                list.setAdapter(adapter);
                                selectedCnanel(view,position);
                                break;
                            case 3:  adapter = new ListAdapter(List1.l4);
                                list.setAdapter(adapter);
                                selectedCnanel(view,position);
                                break;
                            case 4:  adapter = new ListAdapter(List1.l5);
                                list.setAdapter(adapter);
                                selectedCnanel(view,position);
                                break;
                            case 5:  adapter = new ListAdapter(List1.l6);
                                list.setAdapter(adapter);
                                selectedCnanel(view,position);
                                break;

                        }}else{

                          /*//  Intent intent = new Intent(this, Main2Activity.class);
                            Intent intent = new Intent(this, Main2Activity.class);
                            startActivity(intent);
                            // Получаем текстовое поле в текущей Activity

                            // Получае текст данного текстового поля
                            String message = editText.getText().toString();
                            // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
                            // второй параметр - значение этого объекта
                            intent.putExtra(EXTRA_MESSAGE, message);
                            // запуск activity
                            startActivity(intent);
*/

                        }

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }


                })


        );


        try {
            // RecyclerView rv = (RecyclerView) findViewById(R.id.v);
            rv.setHasFixedSize(true);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setHasFixedSize(true);

            chanel = new ArrayList<Chanel>();
            chanel.add(new Chanel("Беларусь-1","10-00","peredacha",R.drawable.bt1n));
            chanel.add(new Chanel("Беларусь-2","10-00","peredacha",R.drawable.bt2n));
            chanel.add(new Chanel("СТВ","10-00","peredacha",R.drawable.ctv2018));
            chanel.add(new Chanel("Мир","10-00","peredacha",R.drawable.mirtvn));
            chanel.add(new Chanel("НТВ","10-00","peredacha",R.drawable.ntvbeln));
            chanel.add(new Chanel("ОНТ","10-00","peredacha",R.drawable.ontn));


             adapter = new RVAdapter(chanel);
            rv.setAdapter(adapter);
        } catch(Exception e){
            Log.d("avi",e.getMessage());
        }


        try {
            list.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, rv ,new RecyclerItemClickListener.OnItemClickListener() {

                        @Override
                        public void onItemClick(View view, int position) {
                            Log.d("tapitapi",position+"");
                            ListAdapter adapter;



                                  //  list.setAdapter(adapter);
                                  //  list.scrollToPosition(7);


                                    view.setBackgroundColor(14);



                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }


                    })


            );


            list.setHasFixedSize(true);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            list.setLayoutManager(llm);
            list.setHasFixedSize(true);

           /* chanel.add(new Chanel("Беларусь-1","10-00","peredacha",R.drawable.bt1n));
            chanel.add(new Chanel("Беларусь-2","10-00","peredacha",R.drawable.bt2n));
            chanel.add(new Chanel("СТВ","10-00","peredacha",R.drawable.ctv2018));
            chanel.add(new Chanel("Мир","10-00","peredacha",R.drawable.mirtvn));
            chanel.add(new Chanel("НТВ","10-00","peredacha",R.drawable.ntvbeln));
            chanel.add(new Chanel("ОНТ","10-00","peredacha",R.drawable.ontn));
*/
/*
            List1.l=new ArrayList<String>();
            List1.l2=new ArrayList<String>();
            List1.l3=new ArrayList<String>();
            List1.l4=new ArrayList<String>();
            List1.l5=new ArrayList<String>();
            List1.l6=new ArrayList<String>();*/

           /* li=new ArrayList<String>();
            li.add("22:10 Х/ф \"Свой чужой сын\", 1-4 с (16+)");
            li.add("Беларусь-2");
            li.add("СТВ");
            li.add("Мир");
            li.add("НТВ");
            li.add("ОНТ");*/


            l = new ArrayList<Chanel>();
            l.add(new Chanel("23:35 \"Орел и Решка. Кругосветка\". Трэвел-шоу (16+)","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("00:25 Перерыв в вещании","10-00","peredacha",R.drawable.bt2n));
            List1.l2=l;
            l = new ArrayList<Chanel>();
            l.add(new Chanel("23:15 \"Документальный спецпроект\" (16+)","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("00:25 Тс Метод 3 и 4 с (18+)","10-00","peredacha",R.drawable.bt2n));
            l.add(new Chanel("02:05 Перерыв в вещании","10-00","peredacha",R.drawable.bt2n));
            List1.l3=l;

            l = new ArrayList<Chanel>();
            l.add(new Chanel("22:10 Х/ф \\\"Свой чужой сын\\\", 1-4 с (16+)\"","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("01:20 Перерыв в вещании","10-00","peredacha",R.drawable.bt2n));
            List1.l4=l;

            l = new ArrayList<Chanel>();
            l.add(new Chanel("22:10 Х/ф \\\"Свой чужой сын\\\", 1-4 с (16+)\"","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("01:20 Перерыв в вещании","10-00","peredacha",R.drawable.bt2n));
            List1.l5=l;

            l = new ArrayList<Chanel>();
            l.add(new Chanel("22:10 Х/ф \\\"Свой чужой сын\\\", 1-4 с (16+)\"","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("01:20 Перерыв в вещании","10-00","peredacha",R.drawable.bt2n));
            List1.l6=l;
/*
            l.add(new Chanel("Беларусь-1","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("Беларусь-2","10-00","peredacha",R.drawable.bt2n));
            l.add(new Chanel("СТВ","10-00","peredacha",R.drawable.ctv2018));
            l.add(new Chanel("Мир","10-00","peredacha",R.drawable.mirtvn));
            l.add(new Chanel("НТВ","10-00","peredacha",R.drawable.ntvbeln));
            l.add(new Chanel("ОНТ","10-00","peredacha",R.drawable.ontn));*/
            //RVAdapter adapter = new RVAdapter(chanel);


            l = new ArrayList<Chanel>();

            l.add(new Chanel("15:30Клуб редакторов. (16+)","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("16:30Мелодрама \"Прошу поверить мне на слово\"","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("20:35Навіны надвор'я","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("21:00Главный эфир","10-00","peredacha",R.drawable.bt1n));

            l.add(new Chanel("22:10 Х/ф \\\"Свой чужой сын\\\", 1-4 с (16+)\"","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("01:20 Перерыв в вещании","10-00","peredacha",R.drawable.bt2n));
            l.add(new Chanel("07:00\"Включайся!\". Утреннее шоу (12+)","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("09:00\"Телебарометр\"","10-00","peredacha",R.drawable.bt2n));

            l.add(new Chanel("06:00\"Доброе утро, Беларусь","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("08:00Новости (с сурдопереводом))","10-00","peredacha",R.drawable.bt2n));
            l.add(new Chanel("08:10\"Зона Х\". Криминальная хроника (16+)","10-00","peredacha",R.drawable.bt1n));
            l.add(new Chanel("08:15\"Доброе утро, Беларусь!","10-00","peredacha",R.drawable.bt2n));



            List1.l=l;
            ListAdapter adapter = new ListAdapter(l);
            list.setAdapter(adapter);

            list.scrollToPosition(8);
        } catch(Exception e){
            Log.d("avi",e.getMessage());
        }


    }


    private class PlayerTasc extends AsyncTask<String,Void,Boolean>{
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepared=true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return prepared;
        }


        protected void onPostExecute(boolean b) {
            super.onPostExecute(b);
            mediaPlayer.start();
        }
    }
}

