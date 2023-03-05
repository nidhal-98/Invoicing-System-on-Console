public class Menu {
    private String[] items;
    
    public Menu(String[] items) {
        this.items = items;
    }
    
    public void show() {
        for (int i = 0; i < items.length; i++) {
            System.out.println((i+1) + ". " + items[i]);
        }
        System.out.print("Enter Number of Option:	");
    }
}