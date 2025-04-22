import java.util.*;

public class Sound {

  /** the array of values in this sound; guaranteed not to be null */
  private int[] samples;

  public Sound(int[] input) {
    samples = input;
  }

  public int limitAmplitude(int limit) {
    int changed = 0;
    for (int i = 0; i < samples.length; i++) {
      if (samples[i] > limit) {
        samples[i] = limit;
        changed++;
      } else if (samples[i] < -limit) {
        samples[i] = -limit;
        changed++;
      }
    }
    return changed;
  }

  public void trimSilenceFromBeginning()
{
    int n = 0;
    while (samples[n] == 0)
        n++;

    int[] newSamples = new int[samples.length - n];

    for (int i = 0; i < newSamples.length; i++)
        newSamples[i] = samples[i + n];

    samples = newSamples;
}
}
