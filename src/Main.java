public class Main {
    public static void main(String[] args) {


        WorldMap worldMap = new WorldMap();
        worldMap.loadMap();
        System.out.println(worldMap.world.get(7));
        worldMap.konzole();
    }
}