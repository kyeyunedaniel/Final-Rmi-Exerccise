
import java.rmi.*;
import java.util.ArrayList;
import java.util.List;
public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{
    //Rooms Available 
    public static int room1= 7;
    public static int room2= 5;
    public static int room3= 4;
    public static int room4= 3;
    public static int room5= 4;

    //Room Prices
    public static int price_1= 55000;
    public static int price_2= 75000;
    public static int price_3= 80000;
    public static int price_4= 150000;
    public static int price_5= 230000;


    //Stores Guests depending on the room type
    public static List<String> room_1 = new ArrayList<String>();
    public static List<String> room_2 = new ArrayList<String>();
    public static List<String> room_3 = new ArrayList<String>();
    public static List<String> room_4 = new ArrayList<String>();
    public static List<String> room_5 = new ArrayList<String>();

    public static List<String> guests = new ArrayList<String>();

    public RoomManagerImpl() throws RemoteException 
    {
        super ();
    }

    public String list()
        throws RemoteException{
            String room_1 = RoomManagerImpl.room1 + " rooms of type 1 is available";
            String room_2 = RoomManagerImpl.room2 + " rooms of type 2 is available";
            String room_3 = RoomManagerImpl.room3 + " rooms of type 3 is available";
            String room_4 = RoomManagerImpl.room4 + " rooms of type 4 is available";
            String room_5 = RoomManagerImpl.room5 + " rooms of type 5 is available";
            return room_1 + "\n" + room_2 + "\n" + room_3 + "\n" + room_4 + "\n" + room_5;
        }

    public String book(String type, String guest_name)
        throws RemoteException{

            if(type.equals("type_1")){
                RoomManagerImpl.room1 = RoomManagerImpl.room1 - 1;
                RoomManagerImpl.room_1.add(guest_name);
                return "Room 1 booked";
            }else if(type.equals("type_2")){
                RoomManagerImpl.room2 = RoomManagerImpl.room2 - 1;
                RoomManagerImpl.room_2.add(guest_name);
                return "Room 2 booked";
            }else if(type.equals("type_3")){
                RoomManagerImpl.room3 = RoomManagerImpl.room3 - 1;
                RoomManagerImpl.room_3.add(guest_name);
                return "Room 3 booked";
            }else if(type.equals("type_4")){
                RoomManagerImpl.room4 = RoomManagerImpl.room4 - 1;
                RoomManagerImpl.room_4.add(guest_name);
                return "Room 4 booked";
            }else if(type.equals("type_5")){
                RoomManagerImpl.room5 = RoomManagerImpl.room5 - 1;
                RoomManagerImpl.room_5.add(guest_name);
                return "Room 5 booked";
            }

            return "ROOM TYPE UNAVILABLE ";
        }
    

    @Override
    public List<String> guests() throws RemoteException {
        for(String val : RoomManagerImpl.room_1){
            RoomManagerImpl.guests.add(val);
        }
        for(String val : RoomManagerImpl.room_2){
            RoomManagerImpl.guests.add(val);
        }
        for(String val : RoomManagerImpl.room_3){
            RoomManagerImpl.guests.add(val);
        }
        for(String val : RoomManagerImpl.room_4){
            RoomManagerImpl.guests.add(val);
        }
        for(String val : RoomManagerImpl.room_5){
            RoomManagerImpl.guests.add(val);
       
        }
        return RoomManagerImpl.guests;
    }
    

    @Override
    public String revenue() throws RemoteException {
        int revenue1 = RoomManagerImpl.room_1.size() * RoomManagerImpl.price_1;
        String num1 = "Room 1 : " + revenue1 + " UGX";
        

        int revenue2 = RoomManagerImpl.room_2.size() * RoomManagerImpl.price_2;
        String num2 = "Room 2 : " + revenue2 + " UGX";
        
        

        int revenue3 = RoomManagerImpl.room_3.size() * RoomManagerImpl.price_3;
        String num3 = "Room 3 : " + revenue3+ " UGX";
      

        int revenue4 = RoomManagerImpl.room_4.size() * RoomManagerImpl.price_4;
        String num4 = "Room 4 : " + revenue4 + " UGX";
        

        int revenue5 = RoomManagerImpl.room_5.size() * RoomManagerImpl.price_5;
        String num5 = "Room 5 : " + revenue5 + " UGX";
        
        int total = revenue1+revenue2+revenue3+revenue4+revenue5;

        return num1+"\n"+num2+"\n"+num3+"\n"+num4+"\n"+num5 + "\n"+ "Total Revenue is :" + total ;
    }
}