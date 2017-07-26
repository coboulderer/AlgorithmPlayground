package rk.algos.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import rk.AlgoTestingBase;

/**
 * Class for testing various graph related functions
 */
public class GraphTesting extends AlgoTestingBase {

    private ArrayList<Vertex> vertices;

    @Test
    public void testComputeMinCut() {
        int minValue = 100000;
        for (int i = 0; i < 199; i++) {
            readInGraphData();
            int minCut = ComputeMinCut.computeMinCut(vertices);
            if (minCut < minValue) {
                minValue = minCut;
            }

            print("Mincut for " + i + " iteration:: " + minCut);
        }
        print("Smallest Value found:: " + minValue);
    }

    private void readInGraphData() {
        vertices = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(getClass().getClassLoader().
                getResource("KargerMinCut.txt").getFile()))) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                Vertex n = new Vertex();
                n.value = lineScanner.nextInt();
                while (lineScanner.hasNext()) {
                    n.mEdgesList.add(lineScanner.nextInt());
                }
                vertices.add(n);
            }
        } catch (NullPointerException | FileNotFoundException e) {
            print("Could not find file:: " + e.getMessage());
        }
    }
}
