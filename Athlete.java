import java.util.Random;
public class Athlete {
    private int[] distances = {100, 200, 300, 400, 500, 600, 700, 800};
    private int[] percents = {50, 60, 70, 80, 90, 100};
    private String intensity;
    public String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    protected String[] cooldowns = {"Light stretching for 10 minutes.", "Light jogging for 400 meters.", "Put your legs up for 10 minutes."};
    public String cooldown;

    public Athlete() {
        intensity = Information.getIntensity();
    }
    
    public Athlete(String i) {
        intensity = i;
        Information.setIntensity(i);
    }

    /* Depending on the intensity, generates a workout for 5 days, some of which could be rest days
    Pre condition: intensity != null
    */
    public void createSchedule() {
        if(Information.getIntensity().equals("light")) {
            assignWorkouts("medium", "light", "rest", "medium", "light");
            cooldown = cooldowns[0];
        } else if(Information.getIntensity().equals("medium")) {
            assignWorkouts("hard", "light", "rest", "medium", "medium");
            cooldown = cooldowns[1];
        } else if(Information.getIntensity().equals("hard")) {
            assignWorkouts("hard", "light", "rest", "hard", "light");
            cooldown = cooldowns[2];
        }
    }

    // assigns a workout to each day based on intensity
    protected void assignWorkouts(String a, String b, String c, String d, String e) {
        days[0] = "Monday:" + createWorkout(a);
        days[1] = "Tuesday:" + createWorkout(b);
        days[2] = "Wednesday:" + createWorkout(c);
        days[3] = "Thursday:" + createWorkout(d);
        days[4] = "Friday:" + createWorkout(e);
    }

    // Creates a workout based on how intense it is supposed to be
    protected String createWorkout(String i) {
        String workout = " ";
        Random rand = new Random();
        if(i.equals("light")) {
           workout += (rand.nextInt(2) + 2) + " sets of " + distances[rand.nextInt(7)] + " meters at " + percents[rand.nextInt(3)] + "%.";
        } else if (i.equals("medium")) {
            workout += (rand.nextInt(2) + 2) + " sets of " + distances[rand.nextInt(7)] + " meters at " + percents[rand.nextInt(2) + 2] + "%.";
        } else if (i.equals("hard")) {
            workout += (rand.nextInt(2) + 2) + " sets of " + distances[rand.nextInt(7)] + " meters at " + percents[rand.nextInt(2) + 4] + "%.";
        } else {
            workout += "No exercise! Rest up!";
        }
    return workout;
    }

    public void setIntensity(String i) {
        intensity = i;
    }
}