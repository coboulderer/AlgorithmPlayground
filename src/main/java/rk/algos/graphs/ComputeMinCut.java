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
            int randEdgeIndex = getRandomInt(vertices.get(nIndexOne).mEdgesList.size());
            performCut(nIndexOne, randEdgeIndex);
        }
        return vertices.get(0).mEdgesList.size();
    }

    private static int getRandomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    // TODO clean up & optimize
    private static void performCut(int nVertexIndex, int mEdgeIndex) {
        Vertex nOne = vertices.remove(nVertexIndex);
        int foundIndex = 0;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).value == nOne.mEdgesList.get(mEdgeIndex)) {
                foundIndex = i;
                break;
            }
        }
        Vertex nTwo = vertices.remove(foundIndex);
        checkForNullVertex(nTwo);
        Vertex combinedVertex = new Vertex();
        combinedVertex.value = nOne.value + nTwo.value + 200;
        //remove future self refs that would exist after nOne and nTwo are collapsed
        nOne.mEdgesList.removeIf(m -> m == nTwo.value);
        nTwo.mEdgesList.removeIf(m -> m == nOne.value);
        combinedVertex.mEdgesList.addAll(nOne.mEdgesList);
        combinedVertex.mEdgesList.addAll(nTwo.mEdgesList);

        //update old edges to point to new vertex
        for (int n = 0; n < vertices.size(); n++) {
            for (int m = 0; m < vertices.get(n).mEdgesList.size(); m++) {
                if (vertices.get(n).mEdgesList.get(m) == nOne.value ||
                        vertices.get(n).mEdgesList.get(m) == nTwo.value) {
                    vertices.get(n).mEdgesList.set(m, combinedVertex.value);
                }
            }
        }
        vertices.add(combinedVertex);
    }

    private static void checkForNullVertex(Vertex n) {
        if (n == null) {
            throw new NullPointerException("n is NULL!!");
        }
    }
}
