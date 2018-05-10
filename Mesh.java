public class Mesh implements Network {

    private Vertex[] network;
    private int numberOfVertices;

    public Mesh(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        createModel();
    }



    @Override
    public void createModel() {
        network = new Vertex[numberOfVertices];
        for (int i = 0, name = 'a'; i < numberOfVertices; i++, name++) {
            network[i] = new Vertex((char)name);
        }
        for (int i = 0; i < network.length; i++) {
            for (int j = 0; j < network.length; j++) {
                if(!network[j].equals(network[i])) {
                    network[i].addAjaceny(network[j]);
                }
            }
        }
    }

    @Override
    public Vertex find(char sourceName, char destinationName) {
        for (Vertex v: network) {
            if (v.getName() == destinationName) {
                return v;
            }
        }
        throw new VertexNotFoundException("Could not find vertex" + destinationName);
    }

    @Override
    public void sendMessage(char sourceName, char destinationName, String message) {
        Vertex messageSentTo = find(sourceName, destinationName);
        messageSentTo.addNewMessageSent(message + " (" + sourceName + " sent a message to " + sourceName + ").");
        messageSentTo.addNewMessageRecieved(message + " ( " + destinationName + " received a message from " + sourceName + ").");
        System.out.println("Message successfully sent from " + sourceName + " to " + destinationName);
    }
}