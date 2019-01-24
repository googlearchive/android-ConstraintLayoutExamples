package com.android;

public class KeyCycleExamples {

  /**
   * name, xml, speed, direction
   */
  static String bounce  =
      "<KeyFrameSet>\n"
          + "\n"
          + "<KeyCycle \n"
          + "        motion:framePosition=\"0\"\n"
          + "        motion:target=\"@+id/button\"\n"
          + "        motion:wavePeriod=\"0\"\n"
          + "        motion:waveOffset=\"0dp\"\n"
          + "        motion:waveShape=\"bounce\"\n"
          + "        android:translationY=\"-15dp\"/>\n"
          + "\n"
          + "<KeyCycle \n"
          + "        motion:framePosition=\"34\"\n"
          + "        motion:target=\"@+id/button\"\n"
          + "        motion:wavePeriod=\"2\"\n"
          + "        motion:waveOffset=\"0dp\"\n"
          + "        motion:waveShape=\"bounce\"\n"
          + "        android:translationY=\"-39dp\"/>\n"
          + "\n"
          + "<KeyCycle \n"
          + "        motion:framePosition=\"100\"\n"
          + "        motion:target=\"@+id/button\"\n"
          + "        motion:wavePeriod=\"3\"\n"
          + "        motion:waveOffset=\"0dp\"\n"
          + "        motion:waveShape=\"bounce\"\n"
          + "        android:translationY=\"-8dp\"/>\n"
          + "\n"
          + "</KeyFrameSet>\n";

  static String look_at_me = "<KeyFrameSet>\n"
      + "\n"
      + "<KeyCycle \n"
      + "        motion:framePosition=\"0\"\n"
      + "        motion:target=\"@+id/button\"\n"
      + "        motion:wavePeriod=\"0\"\n"
      + "        motion:waveOffset=\"1\"\n"
      + "        motion:waveShape=\"sin\"\n"
      + "        android:scaleX=\"0.3\"/>\n"
      + "\n"
      + "<KeyCycle \n"
      + "        motion:framePosition=\"18\"\n"
      + "        motion:target=\"@+id/button\"\n"
      + "        motion:wavePeriod=\"0\"\n"
      + "        motion:waveOffset=\"1\"\n"
      + "        motion:waveShape=\"sin\"\n"
      + "        android:scaleX=\"0.3\"/>\n"
      + "\n"
      + "<KeyCycle \n"
      + "        motion:framePosition=\"100\"\n"
      + "        motion:target=\"@+id/button\"\n"
      + "        motion:wavePeriod=\"3\"\n"
      + "        motion:waveOffset=\"1\"\n"
      + "        motion:waveShape=\"sin\"\n"
      + "        android:scaleX=\"0\"/>\n"
      + "\n"
      + "</KeyFrameSet>\n";


  static String nope =  "<KeyFrameSet>\n"
      + "\n"
      + "<KeyCycle \n"
      + "        motion:framePosition=\"0\"\n"
      + "        motion:target=\"@+id/button\"\n"
      + "        motion:wavePeriod=\"0\"\n"
      + "        motion:waveOffset=\"1dp\"\n"
      + "        motion:waveShape=\"sin\"\n"
      + "        android:translationX=\"49dp\"/>\n"
      + "\n"
      + "<KeyCycle \n"
      + "        motion:framePosition=\"18\"\n"
      + "        motion:target=\"@+id/button\"\n"
      + "        motion:wavePeriod=\"2\"\n"
      + "        motion:waveOffset=\"0dp\"\n"
      + "        motion:waveShape=\"sin\"\n"
      + "        android:translationX=\"42dp\"/>\n"
      + "\n"
      + "<KeyCycle \n"
      + "        motion:framePosition=\"100\"\n"
      + "        motion:target=\"@+id/button\"\n"
      + "        motion:wavePeriod=\"2\"\n"
      + "        motion:waveOffset=\"0dp\"\n"
      + "        motion:waveShape=\"sin\"\n"
      + "        android:translationX=\"2dp\"/>\n"
      + "\n"
      + "</KeyFrameSet>\n";


  public static String [][] all =  {
      {"Bounce" , bounce, "3" , "4"},
      {"Look at Me" , look_at_me, "1" , "0"},
      {"Wrong password" , nope, "2" , "0"}

  };


}
