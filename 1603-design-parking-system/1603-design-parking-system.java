class ParkingSystem {
int bigi;
int mediumi;
int smalli;
public ParkingSystem(int big, int medium, int small) {
bigi=big;
mediumi=medium;
smalli=small;
}

public boolean addCar(int carType) {
   if (carType==1 && bigi>0){
       bigi--;
       return true;
   }
   else if (carType==2 && mediumi>0){
       mediumi--;
       return true;
   }
   else if (carType==3 && smalli>0){
       smalli--;
       return true;
   }
    else{
        return false;
        }
    
}
}