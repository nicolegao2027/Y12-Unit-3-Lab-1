import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreTester {
    @Test
    public void addBookTest(){
        Store store = new Store();
        Book book = new Book("Book", "Library",10, "Book to learn Java", 300, "December 13, 2025","Jack Blob", "50000","3rd Edition", "Java");
        store.addBook(book);
        assertTrue(true);
    }
    @Test
    public void addPhoneTest(){
        Store store = new Store();
        Phone phone = new Phone("iPhone","pocket",2000, "Nicole's Phone", 56,"iphone 17 pro", "Apple", "ios", "LTE", 6);
        store.addPhone(phone);
        assertTrue(true);
    }
    @Test
    public void addBookAndPhoneTest(){
        Store store = new Store();
        Book book = new Book("Book", "Library",10, "Book to learn Java", 300, "December 13, 2025","Jack Blob", "50000" ,"3rd Edition", "Java");
        Phone phone = new Phone("iPhone","pocket",2000, "Nicole's Phone", 56,"iphone 17 pro", "Apple", "iOS", "LTE", 6);
        store.addBook(book);
        store.addPhone(phone);
        assertTrue(true);
    }
    @Test
    public void updatePhonesLocationAndGetAllPhonesTest(){
        Store store = new Store();
        Phone p1 = new Phone("iPhone", "Room 101", 1000, "Phone", 256, "14 Pro", "Apple", "iOS", "5G", 6);
        Phone p2 = new Phone("Samsung", "Room 102", 800, "Phone", 128, "7", "Samsung", "Android", "LTE", 6);
        store.addPhone(p1);
        store.addPhone(p2);

        store.updatePhonesLocation("Room 512");
        ArrayList<Phone> phones = store.getAllPhones();

        for(Phone phone:phones){
            assertEquals(phone.getLocation(), "Room 512");
        }
    }
    @Test
    public void getItemsTest(){
        Store store = new Store();
        Book book1 = new Book("Book1", "Library",10, "Book to learn Java", 300, "December 13, 2025","Jack Blob", "50000" ,"3rd Edition", "Java");
        Book book2 = new Book("Book2", "Library",20, "Book to learn Python", 300, "December 13, 2025","Jack Blob", "50000" ,"3rd Edition", "Java");
        Phone phone = new Phone("Samsung", "Room 102", 800, "Phone", 128, "7", "Samsung", "Android", "LTE", 6);
        store.addBook(book1);
        store.addBook(book2);
        store.addPhone(phone);

        assertEquals(store.getItems("Book").size(), 2);
        assertEquals(store.getItems("Phone").size(), 1);
    }
    @Test
    public void updateItemsTest() {
        Store store = new Store();
        Phone p1 = new Phone("Samsung", "Room 102", 800, "Phone", 128, "7", "Samsung", "Android", "LTE", 6);
        store.addPhone(p1);
        store.updateItems("phone", "location", "Room 511");
        assertEquals(p1.getLocation(), "Room 511");

        store.updateItems("phone", "description", "Broken");
        assertEquals(p1.getDescription(), "Broken");

        Book book1 = new Book("Book1", "Library",10, "Book to learn Java", 300, "December 13, 2025","Jack Blob", "50000" ,"3rd Edition", "Java");
        store.addBook(book1);
        store.updateItems("book", "price", "30");
        assertEquals(book1.getPrice(), 30);

        Magazine magazine = new Magazine("magazine1", "Bookshelf", 300,"Fashion Magazine", 455, "December 13, 2025","Jack Bobby","Vogue","December 27, 2025");
        store.addMagazine(magazine);
        store.updateItems("Magazine", "datePublished", "November 23, 2025");
        assertEquals(magazine.getDatePublished(), "November 23, 2025");

        Arduino a1 = new Arduino("adruino1","lab",570,"An arduino",700,"3","Android","Android","5");
        store.addArduino(a1);
        store.updateItems("Arduino", "storageCapacity", "860");
        assertEquals(a1.getStorageCapacity(), 860);

        ElectronicItem e1 = new ElectronicItem("ipad","bag",450,"Big ipad", 600, "6", "Apple", "iOS");
        store.addItems(e1);
        store.updateItems("ElectronicItem","operatingSystem", "Android");
        assertEquals(e1.getOperatingSystem(),"Android");
    }
}
