//import java.util.List;
//import java.util.Map;
//
//enum Size {
//    SMALL(1),
//    MEDIUM(2),
//    LARGE(3);
//    public final int size;
//
//    Size(int size) {
//        this.size = size;
//    }
//
//    public int getSize() {
//        return size;
//    }
//}
//
//class Locker {
//    int size;
//    String id;
//    boolean isAvailable;
//    Package pack;
//
//    Locker() {
//
//    }
//
//    public int getSize() {
//        return this.size;
//    }
//
//    public boolean isAvailable() {
//        return this.isAvailable;
//    }
//
//    public void addPackage(Package pack) {
//        this.isAvailable = false;
//        this.pack = pack;
//    }
//
//    public Package removePackage() {
//    }
//}
//
//class Package {
//    String id;
//    int packageSize;
//    User user;
//}
//
//class Code {
//    String code;
//    boolean isExpire;
//}
//
//class User {
//
//}
//
//class DeliveryPerson {
//}
//
//class LockerSystem {
//    List<Locker> smallLockersAvail;
//    List<Locker> smallLockersNotAvail;
//    Map<String, Object[]> assignLockerMap;
//
//    public Locker findLocker(Package pack) {
//        if (pack.packageSize == 1 && smallLockersAvail.size() > 0) {
//            locker.isAvailable == false;
//            return locker;
//        }
//        return null;
//    }
//
//    public String addPackage(Package pack) {
//        Locker locker = findLocker(pack);
//
//        locker.addPackage(pack);
//        //get a code;
//
//        notifyUser(code, pack.user);
//    }
//
//    public Package pickUp(String lockerCode) {
//        Code code = assignLockerMap.get(lockerCode);
//        if (code == null || code.isExpire) return null;
//        Locker locker = (Locker) assignLockerMap.get(lockerCode)[1];
//        Package pack = locker.removePackage();
//        assignLockerMap.remove(lockerCode);
//        return pack;
//    }
//}
//
//
//
//
//
//
//
//
//
//
