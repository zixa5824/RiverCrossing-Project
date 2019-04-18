package RiverCrossing;


public class CrossersFactory {

    public ICrosser getCrosser(String type){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("FARMER")){
            return new Farmer();

        } else if(type.equalsIgnoreCase("CARNIVOROUS")){
            return new Carnivorous();

        } else if(type.equalsIgnoreCase("HERBIVOROUS")){
            return new Herbivorous();
        } else if(type.equalsIgnoreCase("PLANT")){
            return new Plant();
        }

        return null;
    }
}

