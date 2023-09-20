import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    PurchaseItem item1 = new PurchaseItem(11, 1, "хлеб", 40, 3); //перечисляем все данные которые нужны конструктору
    PurchaseItem item2 = new PurchaseItem(222, 22, "булка", 30, 1);
    PurchaseItem item3 = new PurchaseItem(3, 30, "картошка", 20, 7);

    @Test
    public void test() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1); //добавим несколько элементов в наш репозиторий
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId()); //удали второй элемент id

        PurchaseItem[] expected = {item1, item3}; //ожидаемый без второго элемента
        PurchaseItem[] actual = repo.getItems(); //фактический

        Assertions.assertArrayEquals(expected, actual);
    }
}