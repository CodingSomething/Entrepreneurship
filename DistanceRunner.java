import java.util.Random;
public class DistanceRunner extends Athlete {
  private int[] times = {20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90};
  private String[] pace = {"slow", "fast"};
  private String intensity;
  public String[] cooldowns = {"Light stretching for 10 minutes", "Lightly jog 400 meters", "Put your legs up for 10 minutes"};
  public DistanceRunner() {
    intensity = Information.getIntensity(); 
  }
  
  public DistanceRunner(String i) {
    intensity = i;
    Information.setIntensity(i);
  }

  /* Depending on the intensity, generates a workout for 5 days, some of which could be rest days
  Pre condition: intensity != null
  */
  public void createSchedule() {
    if(Information.getIntensity().equals("light")) {
      assignWorkouts("light", "light", "medium", "light", "rest");
      cooldown = cooldowns[0];
    } else if(Information.getIntensity().equals("medium")) {
      assignWorkouts("hard", "light", "rest", "medium", "light");
      cooldown = cooldowns[1];
    } else if(Information.getIntensity().equals("hard")) {
      assignWorkouts("hard", "light", "medium", "medium", "light");
      cooldown = cooldowns[2];
    }
  }

  // Creates a workout based on how intense it is supposed to be
  @Override
  protected String createWorkout(String i) {
    Random rand = new Random();
    String workout = " ";
    String milePace = pace[rand.nextInt(2)];
    if(i.equals("light")) {
      if(milePace.equals("slow")) {
        workout += "run for " + times[rand.nextInt(2) + 2] + " minutes at " + milePace + " mile pace";
      } else {
        workout += "run for " + times[rand.nextInt(2)] + " minutes at " + milePace + " mile pace";
      }
    } else if (i.equals("medium")) {
      if(milePace.equals("slow")) {
        workout += "run for " + times[rand.nextInt(3) + 5] + " minutes at " + milePace + " mile pace";
      } else {
        workout += "run for " + times[rand.nextInt(3) + 2] + " minutes at " + milePace + " mile pace";
      }
    } else if (i.equals("hard")) {
      if(milePace.equals("light")) {
        workout += "run for " + times[rand.nextInt(4) + 11] + " minutes at " + milePace + " mile pace";
      } else {
        workout += "run for " + times[rand.nextInt(3) + 8] + " minutes at " + milePace + " mile pace";
      }
    } else {
      workout += "No workout! Rest up!";
    }
    return workout;
  }

  public void setIntensity(String i) {
    intensity = i;
  }

}