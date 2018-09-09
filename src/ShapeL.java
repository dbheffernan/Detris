

import java.awt.*;

public class ShapeL extends Tetromino {
        public static final int rotationStep = 0;
        public static final int rotationStepMax = 3;
        public static final int[][][] grid2 = {{{0,0,0,0},
                                                {0,1,1,1},
                                                {0,1,0,0},
                                                {0,0,0,0}},
                
                                               {{0,1,1,0},
                                                {0,0,1,0},
                                                {0,0,1,0},
                                                {0,0,0,0}},
                                   
                                               {{0,0,0,1},
                                                {0,1,1,1},
                                                {0,0,0,0},
                                                {0,0,0,0}},
                                   
                                               {{0,0,1,0},
                                                {0,0,1,0},
                                                {0,0,1,1},
                                                {0,0,0,0}}};
                                    
        public static final int startX = 100;
        public static final int startY = 40;
        public static final int clear_right = 3;
        public static final int clear_left = 2;
        public static final int color = 4;
        public static final Color display = Color.ORANGE;
        
        public ShapeL() {
            super(rotationStep, rotationStepMax, grid2, startX, startY,color, display, clear_right, clear_left);
            }
}
