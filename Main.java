public class Main {
    public static void main(String[] args) {
        int numberOfConnectedDevices = 5;
        Mesh mesh = new Mesh(numberOfConnectedDevices);
        for (int i = 'a'; i < 'a'+numberOfConnectedDevices; i++) {
            mesh.sendMessage('a', (char) i, "message");
        }
    }
}
