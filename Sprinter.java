import java.util.Random;
public class Sprinter extends Athlete {
  private int[] distances = {100, 150, 200, 250, 300, 350, 400};
  private int[] percents = {50, 60, 70, 80, 90, 100};
  private String intensity;

  public Sprinter() {
    intensity = Information.getIntensity();
  }
   public String[] cooldowns = {"Light stretching for 10 minutes", "Lightly jog 400 meters", "Put your legs up for 10 minutes"};
  public Sprinter(String i) {
    intensity = i;
    Information.setIntensity(i);
  }

  /* Depending on the intensity, generates a workout for 5 days, some of which could be rest days
  Pre condition: intensity != null
  */
  public void createSchedule() {
    if(Information.getIntensity().equals("light")) {
      assignWorkouts("medium", "rest", "medium", "light", "rest");
      cooldown = cooldowns[0];
    } else if(Information.getIntensity().equals("medium")) {
      assignWorkouts("hard", "light", "medium", "medium", "rest");
      cooldown = cooldowns[1];
    } else if(Information.getIntensity().equals("hard")) {
      assignWorkouts("hard", "light", "hard", "light", "hard");
      cooldown = cooldowns[2];
    }
  }

  // Creates a workout based on how intense it is supposed to be
  @Override
  protected String createWorkout(String i) {
    String workout = " ";
    Random rand = new Random();
    if(i.equals("light")) {
      workout += (rand.nextInt(2) + 4) + " sets of " + distances[rand.nextInt(3)] + " meters at " + percents[rand.nextInt(3)] + "%.";
    } else if (i.equals("medium")) {
      workout += (rand.nextInt(2) + 3) + " sets of " + distances[rand.nextInt(2) + 3] + " meters at " + percents[rand.nextInt(2) + 2] + "%.";
    } else if (i.equals("hard")) {
      workout += (rand.nextInt(2) + 2) + " sets of " + distances[rand.nextInt(5) + 2] + " meters at " + percents[rand.nextInt(2) + 4] + "%.";
    } else {
      workout += "No exercise! Rest up!";
    }
    return workout;
  }

  public void setIntensity(String i) {
    intensity = i;
  }

}