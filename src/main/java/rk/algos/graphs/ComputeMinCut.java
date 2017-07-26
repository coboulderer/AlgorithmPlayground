package rk.algos.graphs;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Contains logic to perform min cut calculation
 */
public class ComputeMinCut {

    private static ArrayList<Vertex> vertices;

    public static int computeMinCut(ArrayList<Vertex> nVertices) {
        vertices = nVertices;
        while (vertices.size() > 2) {
            int nIndexOne = getRandomInt(vertices.size());
            performCut(nIndexOne);
        }
        return vertices.get(0).mEdgesList.size();
    }

    private static int getRandomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    private static void performCut(int nIndexOne) {
        Vertex nOne = vertices.remove(nIndexOne);
        int nIndexTwo = getConnectedVertexRandomlyFromEdges(nOne);
        Vertex nTwo = vertices.remove(nIndexTwo);
        Vertex combinedVertex = combineVertices(nOne, nTwo);
        updateAllOtherVertices(nOne.value, nTwo.value, combinedVertex.value);
        vertices.add(combinedVertex);
    }

    private static int getConnectedVertexRandomlyFromEdges(Vertex n) {
        int randEdgeIndex = getRandomInt(n.mEdgesList.size());
        int foundIndex = 0;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).value == n.mEdgesList.get(randEdgeIndex)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    private static Vertex combineVertices(Vertex nOne, Vertex nTwo) {
        Vertex combinedVertex = new Vertex();
        combinedVertex.value = nOne.value + nTwo.value + getRandomInt(200) + 200;
        //remove future self refs that would exist after nOne and nTwo are collapsed
        nOne.mEdgesList.removeIf(m -> m == nTwo.value);
        nTwo.mEdgesList.removeIf(m -> m == nOne.value);
        combinedVertex.mEdgesList.addAll(nOne.mEdgesList);
        combinedVertex.mEdgesList.addAll(nTwo.mEdgesList);
        return combinedVertex;
    }

    private static void updateAllOtherVertices(int nOneValue, int nTwoValue, int combinedValue) {
        // TODO - improve quadratic runtime possible?
        for (int n = 0; n < vertices.size(); n++) {
            for (int m = 0; m < vertices.get(n).mEdgesList.size(); m++) {
                if (vertices.get(n).mEdgesList.get(m) == nOneValue || vertices.get(n).mEdgesList.get(m) == nTwoValue) {
                    vertices.get(n).mEdgesList.set(m, combinedValue);
                }
            }
        }
    }
}
