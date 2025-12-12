import java.util.ArrayList;

public class Store {
    private ArrayList<CISItem> cisItems;
    public Store(){
        cisItems = new ArrayList<>();
    }
    public void addBook(Book book){
        cisItems.add(book);
    }
    public void addPhone(Phone phone){
        cisItems.add(phone);
    }
    public void addMagazine(Magazine magazine){
        cisItems.add(magazine);
    }
    public void addArduino(Arduino arduino){
        cisItems.add(arduino);
    }
    public void addItems(CISItem cisItem){
        cisItems.add(cisItem);
    }
    public void updatePhonesLocation(String location){
        for(int i=0; i<cisItems.size(); i++){
            CISItem item=cisItems.get(i);
            if(item.getClass()==Phone.class){
                item.setLocation(location);
            }
        }
    }
    public ArrayList<Phone> getAllPhones(){
        ArrayList<Phone> phones = new ArrayList<Phone>();
        for(int i=0; i<cisItems.size(); i++){
            CISItem item = cisItems.get(i);
            if(item.getClass()==Phone.class){
                phones.add((Phone) item);
            }
        }
        return phones;
    }
    public ArrayList<CISItem> getItems(String itemType){
        ArrayList<CISItem> result = new ArrayList<CISItem>();
        String type = itemType.toLowerCase();
        for(CISItem item:cisItems){
            if(type.equals("phone")&&item instanceof Phone){
                result.add(item);
            }
            else if(type.equals("book")&&item instanceof Book){
                result.add(item);
            }
            else if(type.equals("magazine")&&item instanceof Magazine){
                result.add(item);
            }
            else if(type.equals("arduino")&&item instanceof Arduino){
                result.add(item);
            }
            else if(type.equals("electronicitem")&&item instanceof ElectronicItem){
                result.add(item);
            }
            else if(type.equals("readingitem")&&item instanceof ReadingItem){
                result.add(item);
            }
        }
        return result;
    }
    public void updateItems(String itemType, String property, String value){
        ArrayList<CISItem> itemsToUpdate = getItems(itemType);
        for (int i = 0; i < itemsToUpdate.size(); i++) {
            CISItem item = itemsToUpdate.get(i);
            String prop = property.toLowerCase();
            //Cis Items
            if(prop.equals("name")){
                item.setName(value);
            }
            else if(prop.equals("location")){
                item.setLocation(value);
            }
            else if(prop.equals("price")){
                item.setPrice(Integer.parseInt(value));
            }
            else if(prop.equals("description")){
                item.setDescription(value);
            }

            //ReadingItem
            else if(prop.equals("wordcount")){
                if(item instanceof ReadingItem){
                    ((ReadingItem) item).setWordCount(Integer.parseInt(value));
                }
            }
            else if(prop.equals("datepublished")){
                if(item instanceof ReadingItem){
                    ((ReadingItem) item).setDatePublished(value);
                }
            }
            else if(prop.equals("author")){
                if(item instanceof ReadingItem){
                    ((ReadingItem) item).setAuthor(value);
                }
            }

            //Book
            else if(prop.equals("isbn")){
                if(item instanceof Book){
                    ((Book) item).setIsbn(value);
                }
            }
            else if(prop.equals("edition")){
                if(item instanceof Book){
                    ((Book) item).setEdition(value);
                }
            }
            else if(prop.equals("title")){
                if(item instanceof Book){
                    ((Book) item).setTitle(value);
                }
            }

            //Magazine
            else if(prop.equals("coverstorytitle")){
                if(item instanceof Magazine){
                    ((Magazine) item).setCoverStoryTitle(value);
                }
            }
            else if(prop.equals("printdate")){
                if(item instanceof Magazine){
                    ((Magazine) item).setPrintDate(value);
                }
            }
            //ElectronicItem
            else if(prop.equals("storagecapacity")){
                if(item instanceof ElectronicItem){
                    ((ElectronicItem) item).setStorageCapacity(Integer.parseInt(value));
                }
            }
            else if(prop.equals("model")){
                if(item instanceof ElectronicItem){
                    ((ElectronicItem) item).setModel(value);
                }
            }
            else if(prop.equals("maker")){
                if(item instanceof ElectronicItem){
                    ((ElectronicItem) item).setMaker(value);
                }
            }
            else if(prop.equals("operatingsystem")){
                if(item instanceof ElectronicItem){
                    ((ElectronicItem) item).setOperatingSystem(value);
                }
            }

            //Phone
            else if(prop.equals("networktype")){
                if(item instanceof Phone){
                    ((Phone) item).setNetworkType(value);
                }
            }
            else if(prop.equals("screensize")){
                if(item instanceof Phone){
                    ((Phone) item).setScreenSize(Integer.parseInt(value));
                }
            }
            //Arduino
            else if (prop.equals("version")){
                if(item instanceof Arduino){
                    ((Arduino) item).setVersion(value);
                }
            }
        }
    }
    public void showAllInfo(){
        for(int i=0;i<cisItems.size();i++){
            CISItem item=cisItems.get(i);
            System.out.println("Item "+(i+1)+": "+ item.getClass().getSimpleName());
            System.out.println("Name: "+item.getName()+"\n"+"Location: "+item.getLocation()+"\n"+"Price: $" + item.getPrice()+"\n"+"Description: "+item.getDescription());
            if(item instanceof ReadingItem){
                ReadingItem readingItem=(ReadingItem)item;
                System.out.println("Word Count: "+readingItem.getWordCount()+"\n"+"Date Published: "+readingItem.getDatePublished()+"\n"+"Author: "+readingItem.getAuthor());
                if(item instanceof Book){
                    Book book=(Book) item;
                    System.out.println("ISBN: "+book.getIsbn()+"\n"+"Edition: "+book.getEdition()+"\n"+"Title: "+book.getTitle());
                }
                if(item instanceof Magazine){
                    Magazine magazine=(Magazine) item;
                    System.out.println("Cover Story Title: "+magazine.getCoverStoryTitle()+"\n"+"Print Date: "+magazine.getPrintDate());
                }
            }

            if(item instanceof ElectronicItem){
                ElectronicItem electronicItem = (ElectronicItem) item;
                System.out.println("Storage Capacity: "+electronicItem.getStorageCapacity()+"GB"+"\n"+"Model: "+electronicItem.getModel()+"\n"+"Maker: "+electronicItem.getMaker()+"\n"+"Operating System: "+electronicItem.getOperatingSystem());
                if(item instanceof Phone){
                    Phone phone=(Phone)item;
                    System.out.println("Network Type: "+phone.getNetworkType()+"\n"+"Screen Size: "+phone.getScreenSize()+" inches");
                }
                if(item instanceof Arduino){
                    Arduino arduino=(Arduino)item;
                    System.out.println("Version: "+arduino.getVersion());
                }
            }
            System.out.println();
        }
    }
}
