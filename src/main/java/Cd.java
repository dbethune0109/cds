import java.util.ArrayList;
import java.time.LocalDateTime;

public class Cd {
  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private static ArrayList<Cd> instances = new ArrayList<Cd>();
  private int mId;

  public Cd(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }


  public String getDescription() {
    return mDescription;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Cd> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Cd find(int id) {
  return instances.get(id - 1);
}
}
