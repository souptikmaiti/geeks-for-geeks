import java.util.ArrayList;
import java.util.List;

class Vehicle__ implements Cloneable {
    private List<String> vehicleList;

    public Vehicle__() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle__(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle__(tempList);
    }
}

// Creational
public class _4_PrototypeDesignPattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle__ a = new Vehicle__();
        a.insertData();

        Vehicle__ b = (Vehicle__) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());
    }
}
