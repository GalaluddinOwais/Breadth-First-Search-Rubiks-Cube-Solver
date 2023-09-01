/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RubiksCube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author G.Owais
 */

public class RC implements Cloneable {

    char[][] S = {
        {'R', 'O', 'G'},
        {'B', 'B', 'B'},
        {'W', 'W', 'W'}};
    char[][] I = {
        {'B', 'R', 'O'},
        {'Y', 'G', 'Y'},
        {'Y', 'G', 'Y'}};
    char[][] A = {
        {'R', 'R', 'R'},
        {'G', 'W', 'G'},
        {'B', 'Y', 'B'}};
    char[][] P = {
        {'O', 'B', 'G'},
        {'O', 'Y', 'W'},
        {'O', 'B', 'G'}};
    char[][] R = {
        {'B', 'Y', 'W'},
        {'R', 'R', 'W'},
        {'O', 'O', 'W'}};
    char[][] L = {
        {'Y', 'W', 'G'},
        {'G', 'O', 'O'},
        {'Y', 'R', 'R'}};

    RC() {
    }

    RC(char[][] S, char[][] A, char[][] P, char[][] R, char[][] L, char[][] I) {
        this.S = S;
        this.A = A;
        this.P = P;
        this.R = R;
        this.L = L;
        this.I = I;

    }





    ArrayList<String> al = new ArrayList(Arrays.asList("NoAction", "rS", "rI", "rR", "rL", "rA", "rP", "rMH", "rMHV", "rMV", "lS", "lI", "lR", "lL", "lA", "lP", "lMH", "lMHV", "lMV"));

    ArrayList<String> the18moves = new ArrayList(Arrays.asList("rS", "rI", "rR", "rL", "rA", "rP", "rMH", "rMHV", "rMV", "lS", "lI", "lR", "lL", "lA", "lP", "lMH", "lMHV", "lMV"));

    void add18Moves() {
        al.addAll(the18moves);
    }

    ArrayList<String> getSeriesOfMovesTo(int index) {

        ArrayList SeriesOfMoves = new ArrayList();

        SeriesOfMoves.add(al.get(index));
        while (index != 0) {
            index = (index - ((index - 1) % 18 + 1)) / 18;

            SeriesOfMoves.add(al.get(index));
        }
        Collections.reverse(SeriesOfMoves);
        return SeriesOfMoves;

    }

    boolean executeSeriesOfMovesAndReturnWhetherSolvedOrNot(ArrayList<String> seriesOfMoves, char[][] S, char[][] A, char[][] P, char[][] R, char[][] L, char[][] I) throws CloneNotSupportedException {
        RC rclone = new RC(S, A, P, R, L, I);
//        System.out.println(seriesOfMoves);     //unhash to view possible series of moves cheked 
        for (int i = 0; i < seriesOfMoves.size(); i++) {

            switch (seriesOfMoves.get(i)) {
                case "NoAction":
                    break;
                case "rS":
                    rclone.RotateSuperior3D();
                    break;
                case "rI":
                    rclone.RotateInferior3D();
                    break;
                case "rR":
                    rclone.RotateRight3D();
                    break;
                case "rL":
                    rclone.RotateLeft3D();
                    break;
                case "rA":
                    rclone.RotateAnterior3D();
                    break;
                case "rP":
                    rclone.RotatePosterior3D();
                    break;
                case "rMH":
                    rclone.RotateMedialHorizontal3D();
                    break;
                case "rMHV":
                    rclone.RotateMedialHorizontalVertical3D();
                    break;
                case "rMV":
                    rclone.RotateMedialVertical3D();
                    break;
                case "lS":
                    rclone.LotateSuperior3D();
                    break;
                case "lI":
                    rclone.LotateInferior3D();
                    break;
                case "lR":
                    rclone.LotateRight3D();
                    break;
                case "lL":
                    rclone.LotateLeft3D();
                    break;
                case "lA":
                    rclone.LotateAnterior3D();
                    break;
                case "lP":
                    rclone.LotatePosterior3D();
                    break;
                case "lMH":
                    rclone.LotateMedialHorizontal3D();
                    break;
                case "lMHV":
                    rclone.LotateMedialHorizontalVertical3D();
                    break;
                case "lMV":
                    rclone.LotateMedialVertical3D();
                    break;
            }
//            rclone.printCube();System.out.println("_________");//unhash to view changes over the cube 
        }

        return !rclone.isNotSolved();
    }

    public boolean isNotSolved() {
        return this.A[0][0] != this.A[0][1] | this.A[0][1] != this.A[0][2] | this.A[0][2] != this.A[1][0] | this.A[1][0] != this.A[1][1] | this.A[1][1] != this.A[1][2] | this.A[1][2] != this.A[2][0] | this.A[2][0] != this.A[2][1] | this.A[2][1] != this.A[2][2]
                | this.P[0][0] != this.P[0][1] | this.P[0][1] != this.P[0][2] | this.P[0][2] != this.P[1][0] | this.P[1][0] != this.P[1][1] | this.P[1][1] != this.P[1][2] | this.P[1][2] != this.P[2][0] | this.P[2][0] != this.P[2][1] | this.P[2][1] != this.P[2][2]
                | this.S[0][0] != this.S[0][1] | this.S[0][1] != this.S[0][2] | this.S[0][2] != this.S[1][0] | this.S[1][0] != this.S[1][1] | this.S[1][1] != this.S[1][2] | this.S[1][2] != this.S[2][0] | this.S[2][0] != this.S[2][1] | this.S[2][1] != this.S[2][2]
                | this.I[0][0] != this.I[0][1] | this.I[0][1] != this.I[0][2] | this.I[0][2] != this.I[1][0] | this.I[1][0] != this.I[1][1] | this.I[1][1] != this.I[1][2] | this.I[1][2] != this.I[2][0] | this.I[2][0] != this.I[2][1] | this.I[2][1] != this.I[2][2]
                | this.L[0][0] != this.L[0][1] | this.L[0][1] != this.L[0][2] | this.L[0][2] != this.L[1][0] | this.L[1][0] != this.L[1][1] | this.L[1][1] != this.L[1][2] | this.L[1][2] != this.L[2][0] | this.L[2][0] != this.L[2][1] | this.L[2][1] != this.L[2][2]
                | this.R[0][0] != this.R[0][1] | this.R[0][1] != this.R[0][2] | this.R[0][2] != this.R[1][0] | this.R[1][0] != this.R[1][1] | this.R[1][1] != this.R[1][2] | this.R[1][2] != this.R[2][0] | this.R[2][0] != this.R[2][1] | this.R[2][1] != this.R[2][2];
    }

    public void printCube() {
        for (int i = 2; i >= 0; i--) {
            System.out.print("   ");
            for (int j = 2; j >= 0; j--) {
                System.out.print(P[i][j]);

            }
            System.out.println("");
        }
        for (int j = 2; j >= 0; j--) {
            System.out.print(L[j][0]);
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(S[0][j]);
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(R[j][2]);
        }
        System.out.println("");

        for (int j = 2; j >= 0; j--) {
            System.out.print(L[j][1]);
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(S[1][j]);
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(R[j][1]);
        }
        System.out.println("");
        for (int j = 2; j >= 0; j--) {
            System.out.print(L[j][2]);
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(S[2][j]);
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(R[j][0]);
        }

        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.print("   ");
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j]);
            }

            System.out.println("");
        }

        for (int i = 2; i >= 0; i--) {
            System.out.print("   ");
            for (int j = 2; j >= 0; j--) {
                System.out.print(I[i][j]);

            }
            System.out.println("");
        }
    }

    void RotateSuperior3D() {

        RotateSuperior2D();
        char[] holder = this.R[0];
        this.R[0] = this.A[0];
        this.A[0] = holder;

        holder = this.R[0];
        this.R[0] = this.L[0];
        this.L[0] = holder;

        holder = this.R[0];
        this.R[0] = this.P[0];
        this.P[0] = holder;

    }

    void LotateSuperior3D() {

        LotateSuperior2D();
        char[] holder = this.L[0];
        this.L[0] = this.A[0];
        this.A[0] = holder;

        holder = this.R[0];
        this.R[0] = this.L[0];
        this.L[0] = holder;

        holder = this.L[0];
        this.L[0] = this.P[0];
        this.P[0] = holder;

    }

    void RotateInferior3D() {

        LotateInferior2D();
        char[] holder = this.R[2];
        this.R[2] = this.A[2];
        this.A[2] = holder;

        holder = this.R[2];
        this.R[2] = this.L[2];
        this.L[2] = holder;

        holder = this.R[2];
        this.R[2] = this.P[2];
        this.P[2] = holder;

    }

    void LotateInferior3D() {

        RotateInferior2D();
        char[] holder = this.L[2];
        this.L[2] = this.A[2];
        this.A[2] = holder;

        holder = this.R[2];
        this.R[2] = this.L[2];
        this.L[2] = holder;

        holder = this.L[2];
        this.L[2] = this.P[2];
        this.P[2] = holder;

    }

    void RotateSuperior2D() {
        char holder = this.S[0][0];
        this.S[0][0] = this.S[2][0];
        this.S[2][0] = holder;

        holder = this.S[0][1];
        this.S[0][1] = this.S[1][0];
        this.S[1][0] = holder;

        holder = this.S[0][2];
        this.S[0][2] = this.S[2][0];
        this.S[2][0] = holder;

        holder = this.S[1][0];
        this.S[1][0] = this.S[2][1];
        this.S[2][1] = holder;

        holder = this.S[1][2];
        this.S[1][2] = this.S[2][1];
        this.S[2][1] = holder;

        holder = this.S[2][0];
        this.S[2][0] = this.S[2][2];
        this.S[2][2] = holder;

    }

    void RotateRight2D() {
        char holder = this.R[0][0];
        this.R[0][0] = this.R[2][0];
        this.R[2][0] = holder;

        holder = this.R[0][1];
        this.R[0][1] = this.R[1][0];
        this.R[1][0] = holder;

        holder = this.R[0][2];
        this.R[0][2] = this.R[2][0];
        this.R[2][0] = holder;

        holder = this.R[1][0];
        this.R[1][0] = this.R[2][1];
        this.R[2][1] = holder;

        holder = this.R[1][2];
        this.R[1][2] = this.R[2][1];
        this.R[2][1] = holder;

        holder = this.R[2][0];
        this.R[2][0] = this.R[2][2];
        this.R[2][2] = holder;

    }

    void RotateLeft2D() {
        char holder = this.L[0][0];
        this.L[0][0] = this.L[2][0];
        this.L[2][0] = holder;

        holder = this.L[0][1];
        this.L[0][1] = this.L[1][0];
        this.L[1][0] = holder;

        holder = this.L[0][2];
        this.L[0][2] = this.L[2][0];
        this.L[2][0] = holder;

        holder = this.L[1][0];
        this.L[1][0] = this.L[2][1];
        this.L[2][1] = holder;

        holder = this.L[1][2];
        this.L[1][2] = this.L[2][1];
        this.L[2][1] = holder;

        holder = this.L[2][0];
        this.L[2][0] = this.L[2][2];
        this.L[2][2] = holder;

    }

    void RotateInferior2D() {
        char holder = this.I[0][0];
        this.I[0][0] = this.I[2][0];
        this.I[2][0] = holder;

        holder = this.I[0][1];
        this.I[0][1] = this.I[1][0];
        this.I[1][0] = holder;

        holder = this.I[0][2];
        this.I[0][2] = this.I[2][0];
        this.I[2][0] = holder;

        holder = this.I[1][0];
        this.I[1][0] = this.I[2][1];
        this.I[2][1] = holder;

        holder = this.I[1][2];
        this.I[1][2] = this.I[2][1];
        this.I[2][1] = holder;

        holder = this.I[2][0];
        this.I[2][0] = this.I[2][2];
        this.I[2][2] = holder;

    }

    void RotateAnterior2D() {
        char holder = this.A[0][0];
        this.A[0][0] = this.A[2][0];
        this.A[2][0] = holder;

        holder = this.A[0][1];
        this.A[0][1] = this.A[1][0];
        this.A[1][0] = holder;

        holder = this.A[0][2];
        this.A[0][2] = this.A[2][0];
        this.A[2][0] = holder;

        holder = this.A[1][0];
        this.A[1][0] = this.A[2][1];
        this.A[2][1] = holder;

        holder = this.A[1][2];
        this.A[1][2] = this.A[2][1];
        this.A[2][1] = holder;

        holder = this.A[2][0];
        this.A[2][0] = this.A[2][2];
        this.A[2][2] = holder;

    }

    void RotatePosterior2D() {
        char holder = this.P[0][0];
        this.P[0][0] = this.P[2][0];
        this.P[2][0] = holder;

        holder = this.P[0][1];
        this.P[0][1] = this.P[1][0];
        this.P[1][0] = holder;

        holder = this.P[0][2];
        this.P[0][2] = this.P[2][0];
        this.P[2][0] = holder;

        holder = this.P[1][0];
        this.P[1][0] = this.P[2][1];
        this.P[2][1] = holder;

        holder = this.P[1][2];
        this.P[1][2] = this.P[2][1];
        this.P[2][1] = holder;

        holder = this.P[2][0];
        this.P[2][0] = this.P[2][2];
        this.P[2][2] = holder;

    }

    /////////////////////////////////////////////////////////////////////////////
    void LotateSuperior2D() {
        char holder = this.S[0][0];
        this.S[0][0] = this.S[0][2];
        this.S[0][2] = holder;

        holder = this.S[0][1];
        this.S[0][1] = this.S[1][2];
        this.S[1][2] = holder;

        holder = this.S[0][2];
        this.S[0][2] = this.S[2][2];
        this.S[2][2] = holder;

        holder = this.S[1][0];
        this.S[1][0] = this.S[1][2];
        this.S[1][2] = holder;

        holder = this.S[1][2];
        this.S[1][2] = this.S[2][1];
        this.S[2][1] = holder;

        holder = this.S[2][0];
        this.S[2][0] = this.S[2][2];
        this.S[2][2] = holder;

    }

    void LotateRight2D() {
        char holder = this.R[0][0];
        this.R[0][0] = this.R[0][2];
        this.R[0][2] = holder;

        holder = this.R[0][1];
        this.R[0][1] = this.R[1][2];
        this.R[1][2] = holder;

        holder = this.R[0][2];
        this.R[0][2] = this.R[2][2];
        this.R[2][2] = holder;

        holder = this.R[1][0];
        this.R[1][0] = this.R[1][2];
        this.R[1][2] = holder;

        holder = this.R[1][2];
        this.R[1][2] = this.R[2][1];
        this.R[2][1] = holder;

        holder = this.R[2][0];
        this.R[2][0] = this.R[2][2];
        this.R[2][2] = holder;

    }

    void LotateLeft2D() {
        char holder = this.L[0][0];
        this.L[0][0] = this.L[0][2];
        this.L[0][2] = holder;

        holder = this.L[0][1];
        this.L[0][1] = this.L[1][2];
        this.L[1][2] = holder;

        holder = this.L[0][2];
        this.L[0][2] = this.L[2][2];
        this.L[2][2] = holder;

        holder = this.L[1][0];
        this.L[1][0] = this.L[1][2];
        this.L[1][2] = holder;

        holder = this.L[1][2];
        this.L[1][2] = this.L[2][1];
        this.L[2][1] = holder;

        holder = this.L[2][0];
        this.L[2][0] = this.L[2][2];
        this.L[2][2] = holder;

    }

    void LotateInferior2D() {
        char holder = this.I[0][0];
        this.I[0][0] = this.I[0][2];
        this.I[0][2] = holder;

        holder = this.I[0][1];
        this.I[0][1] = this.I[1][2];
        this.I[1][2] = holder;

        holder = this.I[0][2];
        this.I[0][2] = this.I[2][2];
        this.I[2][2] = holder;

        holder = this.I[1][0];
        this.I[1][0] = this.I[1][2];
        this.I[1][2] = holder;

        holder = this.I[1][2];
        this.I[1][2] = this.I[2][1];
        this.I[2][1] = holder;

        holder = this.I[2][0];
        this.I[2][0] = this.I[2][2];
        this.I[2][2] = holder;

    }

    void LotateAnterior2D() {
        char holder = this.A[0][0];
        this.A[0][0] = this.A[0][2];
        this.A[0][2] = holder;

        holder = this.A[0][1];
        this.A[0][1] = this.A[1][2];
        this.A[1][2] = holder;

        holder = this.A[0][2];
        this.A[0][2] = this.A[2][2];
        this.A[2][2] = holder;

        holder = this.A[1][0];
        this.A[1][0] = this.A[1][2];
        this.A[1][2] = holder;

        holder = this.A[1][2];
        this.A[1][2] = this.A[2][1];
        this.A[2][1] = holder;

        holder = this.A[2][0];
        this.A[2][0] = this.A[2][2];
        this.A[2][2] = holder;

    }

    void LotatePosterior2D() {
        char holder = this.P[0][0];
        this.P[0][0] = this.P[0][2];
        this.P[0][2] = holder;

        holder = this.P[0][1];
        this.P[0][1] = this.P[1][2];
        this.P[1][2] = holder;

        holder = this.P[0][2];
        this.P[0][2] = this.P[2][2];
        this.P[2][2] = holder;

        holder = this.P[1][0];
        this.P[1][0] = this.P[1][2];
        this.P[1][2] = holder;

        holder = this.P[1][2];
        this.P[1][2] = this.P[2][1];
        this.P[2][1] = holder;

        holder = this.P[2][0];
        this.P[2][0] = this.P[2][2];
        this.P[2][2] = holder;

    }

    void RotateRight3D() {
        char[][] holder = this.S;
        LotateRight2D();
        this.S = this.R;
        this.R = holder;

        holder = this.R;
        RotateInferior2D();
        this.R = this.I;
        this.I = holder;

        holder = this.L;
        LotateInferior2D();
        this.L = this.I;
        this.I = holder;

        LotateAnterior2D();

        RotatePosterior2D();

        RotateInferior2D();

        RotateSuperior3D();
        holder = this.R;
        RotateSuperior2D();
        this.R = this.S;
        this.S = holder;

        holder = this.I;
        RotateSuperior2D();
        this.I = this.S;
        this.S = holder;

        holder = this.S;
        RotateLeft2D();
        this.S = this.L;
        this.L = holder;

        RotateAnterior2D();
        LotatePosterior2D();
        LotateLeft2D();
        LotateInferior2D();
        LotateInferior2D();
    }

    void LotateRight3D() {
        char[][] holder = this.S;
        LotateRight2D();
        this.S = this.R;
        this.R = holder;

        holder = this.R;
        RotateInferior2D();
        this.R = this.I;
        this.I = holder;

        holder = this.L;
        LotateInferior2D();
        this.L = this.I;
        this.I = holder;

        LotateAnterior2D();

        RotatePosterior2D();

        RotateInferior2D();

        LotateSuperior3D();
        holder = this.R;
        RotateSuperior2D();
        this.R = this.S;
        this.S = holder;

        holder = this.I;
        RotateSuperior2D();
        this.I = this.S;
        this.S = holder;

        holder = this.S;
        RotateLeft2D();
        this.S = this.L;
        this.L = holder;

        RotateAnterior2D();
        LotatePosterior2D();
        LotateLeft2D();
        LotateInferior2D();
        LotateInferior2D();
    }

    void LotateLeft3D() {
        char[][] holder = this.S;
        RotateLeft2D();
        this.S = this.L;
        this.L = holder;

        holder = this.R;
        RotateLeft2D();
        this.R = this.L;
        this.L = holder;

        holder = this.L;
        LotateInferior2D();
        this.L = this.I;
        this.I = holder;

        RotateAnterior2D();

        LotatePosterior2D();

        LotateInferior2D();

        RotateSuperior3D();

        holder = this.L;
        LotateSuperior2D();
        this.L = this.S;
        this.S = holder;

        holder = this.S;
        LotateRight2D();
        this.S = this.R;
        this.R = holder;

        holder = this.I;
        RotateInferior2D();
        this.I = this.R;
        this.R = holder;

        RotateInferior2D();
        LotateAnterior2D();

        RotatePosterior2D();

    }

    void RotateLeft3D() {
        char[][] holder = this.S;
        RotateLeft2D();
        this.S = this.L;
        this.L = holder;

        holder = this.R;
        RotateLeft2D();
        this.R = this.L;
        this.L = holder;

        holder = this.L;
        LotateInferior2D();
        this.L = this.I;
        this.I = holder;

        RotateAnterior2D();

        LotatePosterior2D();

        LotateInferior2D();

        LotateSuperior3D();

        holder = this.L;
        LotateSuperior2D();
        this.L = this.S;
        this.S = holder;

        holder = this.S;
        LotateRight2D();
        this.S = this.R;
        this.R = holder;

        holder = this.I;
        RotateInferior2D();
        this.I = this.R;
        this.R = holder;

        RotateInferior2D();
        LotateAnterior2D();

        RotatePosterior2D();

    }

    void RotateAnterior3D() {
        char[][] holder = this.S;
        this.S = this.A;
        this.A = holder;
        RotateRight2D();
        LotateLeft2D();
        holder = this.A;
        RotateInferior2D();
        RotateInferior2D();
        this.A = this.I;
        this.I = holder;

        holder = this.P;

        RotateInferior2D();
        RotateInferior2D();
        this.P = this.I;
        this.I = holder;

        RotateSuperior3D();

        holder = this.S;

        LotatePosterior2D();
        LotatePosterior2D();
        this.S = this.P;
        this.P = holder;
        LotateRight2D();
        RotateLeft2D();

        holder = this.A;
        this.A = this.P;
        this.P = holder;

        holder = this.P;
        this.P = this.I;
        this.I = holder;
        LotateInferior2D();
        LotateInferior2D();

    }

    void LotateAnterior3D() {
        char[][] holder = this.S;
        this.S = this.A;
        this.A = holder;
        RotateRight2D();
        LotateLeft2D();
        holder = this.A;
        RotateInferior2D();
        RotateInferior2D();
        this.A = this.I;
        this.I = holder;

        holder = this.P;

        RotateInferior2D();
        RotateInferior2D();
        this.P = this.I;
        this.I = holder;

        LotateSuperior3D();

        holder = this.S;

        LotatePosterior2D();
        LotatePosterior2D();
        this.S = this.P;
        this.P = holder;
        LotateRight2D();
        RotateLeft2D();

        holder = this.A;
        this.A = this.P;
        this.P = holder;

        holder = this.P;
        this.P = this.I;
        this.I = holder;
        LotateInferior2D();
        LotateInferior2D();

    }

    void RotatePosterior3D() {
        char[][] holder = this.S;
        RotatePosterior2D();
        RotatePosterior2D();
        this.S = this.P;
        this.P = holder;

        holder = this.A;
        this.A = this.P;
        this.P = holder;

        LotateRight2D();
        RotateLeft2D();
        holder = this.P;
        this.P = this.I;
        this.I = holder;

        RotateInferior2D();
        RotateInferior2D();

        LotateSuperior3D();

        holder = this.P;
        LotateSuperior2D();
        LotateSuperior2D();
        this.P = this.S;
        this.S = holder;

        holder = this.S;
        this.S = this.A;
        this.A = holder;

        RotateRight2D();
        LotateLeft2D();

        holder = this.I;
        this.I = this.A;
        this.A = holder;

        LotateAnterior2D();
        LotateAnterior2D();
    }

    void LotatePosterior3D() {
        char[][] holder = this.S;
        RotatePosterior2D();
        RotatePosterior2D();
        this.S = this.P;
        this.P = holder;

        holder = this.A;
        this.A = this.P;
        this.P = holder;

        LotateRight2D();
        RotateLeft2D();
        holder = this.P;
        this.P = this.I;
        this.I = holder;

        RotateInferior2D();
        RotateInferior2D();

        RotateSuperior3D();

        holder = this.P;
        LotateSuperior2D();
        LotateSuperior2D();
        this.P = this.S;
        this.S = holder;

        holder = this.S;
        this.S = this.A;
        this.A = holder;

        RotateRight2D();
        LotateLeft2D();

        holder = this.I;
        this.I = this.A;
        this.A = holder;

        LotateAnterior2D();
        LotateAnterior2D();

    }

    void RotateMedialHorizontalVertical3D() {

        LotateRight2D();
        RotateLeft2D();
        char[] holder = this.R[1];
        this.R[1] = this.I[1];
        this.I[1] = holder;

        holder = this.R[1];
        this.R[1] = this.L[1];
        this.L[1] = holder;

        holder = this.R[1];
        this.R[1] = this.S[1];
        this.S[1] = holder;
        RotateRight2D();
        LotateLeft2D();

    }

    void LotateMedialHorizontalVertical3D() {
        LotateRight2D();
        RotateLeft2D();
        char[] holder = this.L[1];
        this.L[1] = this.I[1];
        this.I[1] = holder;

        holder = this.L[1];
        this.L[1] = this.R[1];
        this.R[1] = holder;

        holder = this.L[1];
        this.L[1] = this.S[1];
        this.S[1] = holder;
        RotateRight2D();
        LotateLeft2D();

    }

    void RotateMedialVertical3D() {

        char[][] holderr = this.R;
        this.R = this.A;
        this.A = holderr;
        holderr = this.R;
        this.R = this.L;
        this.L = holderr;
        holderr = this.R;
        this.R = this.P;
        this.P = holderr;
        RotateSuperior2D();
        LotateInferior2D();

        LotateRight2D();
        RotateLeft2D();
        char[] holder = this.R[1];
        this.R[1] = this.I[1];
        this.I[1] = holder;

        holder = this.R[1];
        this.R[1] = this.L[1];
        this.L[1] = holder;

        holder = this.R[1];
        this.R[1] = this.S[1];
        this.S[1] = holder;
        RotateRight2D();
        LotateLeft2D();

        holderr = this.L;
        this.L = this.A;
        this.A = holderr;
        holderr = this.L;
        this.L = this.R;
        this.R = holderr;
        holderr = this.L;
        this.L = this.P;
        this.P = holderr;
        LotateSuperior2D();
        RotateInferior2D();

    }

    void LotateMedialVertical3D() {
        char[][] holderr = this.R;
        this.R = this.A;
        this.A = holderr;
        holderr = this.R;
        this.R = this.L;
        this.L = holderr;
        holderr = this.R;
        this.R = this.P;
        this.P = holderr;
        RotateSuperior2D();
        LotateInferior2D();

        LotateRight2D();
        RotateLeft2D();

        char[] holder = this.L[1];
        this.L[1] = this.I[1];
        this.I[1] = holder;

        holder = this.L[1];
        this.L[1] = this.R[1];
        this.R[1] = holder;

        holder = this.L[1];
        this.L[1] = this.S[1];
        this.S[1] = holder;
        RotateRight2D();
        LotateLeft2D();

        holderr = this.L;
        this.L = this.A;
        this.A = holderr;
        holderr = this.L;
        this.L = this.R;
        this.R = holderr;
        holderr = this.L;
        this.L = this.P;
        this.P = holderr;
        LotateSuperior2D();
        RotateInferior2D();
    }

    void LotateMedialHorizontal3D() {
        char[][] holderr = this.S;
        this.S = this.A;
        this.A = holderr;

        holderr = this.A;
        RotateInferior2D();
        RotateInferior2D();
        this.A = this.I;
        this.I = holderr;

        RotateRight2D();
        LotateLeft2D();
        holderr = this.I;
        this.I = this.P;
        this.P = holderr;

        RotatePosterior2D();
        RotatePosterior2D();

        RotateMedialHorizontalVertical3D();

        holderr = this.A;
        this.A = this.S;
        this.S = holderr;
        holderr = this.I;
        RotateSuperior2D();
        RotateSuperior2D();
        this.I = this.S;
        this.S = holderr;

        LotateRight2D();
        RotateLeft2D();

        holderr = this.P;
        this.P = this.S;
        this.S = holderr;
        LotateSuperior2D();
        LotateSuperior2D();
    }

    void RotateMedialHorizontal3D() {
        char[][] holderr = this.S;
        this.S = this.A;
        this.A = holderr;

        holderr = this.A;
        RotateInferior2D();
        RotateInferior2D();
        this.A = this.I;
        this.I = holderr;

        RotateRight2D();
        LotateLeft2D();
        holderr = this.I;
        this.I = this.P;
        this.P = holderr;

        RotatePosterior2D();
        RotatePosterior2D();

        LotateMedialHorizontalVertical3D();

        holderr = this.A;
        this.A = this.S;
        this.S = holderr;
        holderr = this.I;
        RotateSuperior2D();
        RotateSuperior2D();
        this.I = this.S;
        this.S = holderr;

        LotateRight2D();
        RotateLeft2D();

        holderr = this.P;
        this.P = this.S;
        this.S = holderr;
        LotateSuperior2D();
        LotateSuperior2D();

    }
    
        public static char[][] deepCopy(char[][] original) {
    if (original == null) {
        return null;
    }

    final char[][] result = new char[original.length][];
    for (int i = 0; i < original.length; i++) {
        result[i] = Arrays.copyOf(original[i], original[i].length);
        // For Java versions prior to Java 6 use the next:
        // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
    }
    return result;
}
    
        public static void main(String[] args) throws CloneNotSupportedException {


        System.out.println("       _________________________                                        ________________________");
        System.out.println("       |       |        |       |\\                                     /   1   /   2   /   3   /|");
        System.out.println("       |  37   |   38   |  39   |4\\                                   /_______/_______/_______/2|");
        System.out.println("       |_______|________|_______|6|\\                                 /   4   /   5   /   6   /|1|");
        System.out.println("       |       |        |       |\\|4\\                               /_______/_______/_______/2| |");
        System.out.println("       |  40   |   41   |  42   |4\\7|\\                             /   7   /   8   /   9   /|0|/|");
        System.out.println("       |_______|________|_______|9|\\|4\\                           /_______/_______/_______/1| /2|");
        System.out.println("       |       |        |       |\\|5\\8|                           |       |       |       |9|/|4|");
        System.out.println("       |  43   |   44   |  45   |5\\0|\\|                           |   10  |   11  |   12  | /2|/|");
        System.out.println("       |_______|________|_______|2|\\|5\\  /--rotate the whole----- |_______|_______|_______|/|3/2|");
        System.out.println("        \\  28   \\   29   \\  30   \\|5\\1| /   cube 180°             |       |       |       |2|/|7/");
        System.out.println("         \\_______\\________\\_______\\3|\\| \\   and have an           |   13  |   14  |   15  |2/2|/");
        System.out.println("          \\  31   \\  32    \\  33   \\|5\\  \\--underview------------ |_______|_______|_______|/|6/");
        System.out.println("           \\-------\\--------\\-------\\4|                           |       |       |       |2|/");
        System.out.println("            \\  34   \\  35    \\  36   \\|                           |   16  |   17  |   18  |5/");
        System.out.println("             ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾                            |_______|_______|_______|/");

        char[][] SS = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        char[][] II = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        char[][] AA = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        char[][] PP = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        char[][] RR = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        char[][] LL = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        java.util.Scanner s = new java.util.Scanner(System.in);
        int counter = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                counter++;
                System.out.print(counter + ":");
                SS[i][j] = s.next().charAt(0);
            }
        }

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                counter++;
                System.out.print(counter + ":");
                AA[i][j] = s.next().charAt(0);

            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                counter++;
                System.out.print(counter + ":");
                RR[i][j] = s.next().charAt(0);

            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                counter++;
                System.out.print(counter + ":");
                II[i][j] = s.next().charAt(0);

            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                counter++;
                System.out.print(counter + ":");
                PP[i][j] = s.next().charAt(0);

            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                counter++;
                System.out.print(counter + ":");
                LL[i][j] = s.next().charAt(0);

            }
        }
        System.out.println("");

        RC rc = new RC(SS, AA, PP, RR, LL, II);
        rc.printCube();
        if (rc.isNotSolved() == false) {
            System.out.println("solved in less than a second yaay");
            return;
        }
        int move = 1;
        while (true) {
            if (rc.executeSeriesOfMovesAndReturnWhetherSolvedOrNot(rc.getSeriesOfMovesTo(move), deepCopy(SS), deepCopy(AA), deepCopy(PP), deepCopy(RR), deepCopy(LL), deepCopy(II))) {
                System.out.println(rc.getSeriesOfMovesTo(move) + " sequence of moves solves your cube!!");
                break;
            } else {
                move++;
                if (move % 18 == 0) {
                    rc.add18Moves();
                }

            }
        }

    }

}
