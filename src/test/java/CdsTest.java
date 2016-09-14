import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
public class CdsTest {

  @Test
  public void Cds_instantiatesCorrectly_true() {
    Cd myCds = new Cd("Mow the lawn");
    assertEquals(true, myCds instanceof Cd);
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
  Cd myCds = new Cd("Mow the lawn");
  assertEquals(false, myCds.isCompleted());
  }
  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Cd myCds = new Cd("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myCds.getCreatedAt().getDayOfWeek());
}
@Test
 public void all_returnsAllInstancesOfCds_true() {
   Cd firstCds = new Cd("Mow the lawn");
   Cd secondCds = new Cd("Buy groceries");
   assertEquals(true, Cd.all().contains(firstCds));
   assertEquals(true, Cd.all().contains(secondCds));
 }

 @Test
  public void clear_emptiesAllCdssFromArrayList_0() {
  Cd myCds = new Cd("Mow the lawn");
  Cd.clear();
  assertEquals(Cd.all().size(), 0);
  }
  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Cd.clear();  // Remember, the test will fail without this line! We need to empty leftover Cdss from previous tests!
    Cd myCds = new Cd("Mow the lawn");
    assertEquals(1, myCds.getId());
  }
  @Test
public void find_returnsCdsWithSameId_secondCds() {
  Cd firstCds = new Cd("Mow the lawn");
  Cd secondCds = new Cd("Buy groceries");
  assertEquals(Cd.find(secondCds.getId()), secondCds);
}
}
