

import java.awt.*;

public class ShapeT extends Tetromino {
        public static final int rotationStep = 0;
        public static final int rotationStepMax = 3;
        public static final int[][][] grid2 = {{{0,0,0,1},
                                                {0,0,1,1},
                                                {0,0,0,1},
                                                {0,0,0,0}},
                
                                               {{0,0,0,0},
                                                {0,0,1,0},
                                                {0,1,1,1},
                                                {0,0,0,0}},
                                   
                                               {{0,1,0,0},
                                                {0,1,1,0},
                                                {0,1,0,0},
                                                {0,0,0,0}},
                                   
                                               {{0,1,1,1},
                                                {0,0,1,0},
                                                {0,0,0,0},
                                                {0,0,0,0}}};
                                    
        public static final int startX = 100;
        public static final int startY = 40;
        public static final int clear_right = 3;
        public static final int clear_left = 0;
        public static final int color =1;
        public static final Color display = Color.PINK;

        public ShapeT() {
            super(rotationStep, rotationStepMax, grid2, startX, startY,color, display, clear_right, clear_left);
            }
}
