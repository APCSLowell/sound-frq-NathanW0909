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

  public void trimSilenceFromBeginning() {
    int index = 0;
    while (index < samples.length && samples[index] == 0) {
      index++;
    }
    int[] trimmed = Arrays.copyOfRange(samples, index, samples.length);
    samples = trimmed;
  }

  public int[] getSamples() {
    return samples;
  }
}
