

import java.awt.*;

public class ShapeS extends Tetromino {
        public static final int rotationStep = 0;
        public static final int rotationStepMax = 1;
        public static final int[][][] grid2 = {{{0,1,0,0},
                                                {0,1,1,0},
                                                {0,0,1,0},
                                                {0,0,0,0}},
                
                                               {{0,0,1,1},
                                                {0,1,1,0},
                                                {0,0,0,0},
                                                {0,0,0,0}}};
                                    
        public static final int startX = 200;
        public static final int startY = 200;
        public static final int clear_right = 3;
        public static final int clear_left = 0;
        public static final int color = 6;
        public static final Color display = Color.GREEN;

        public ShapeS() {
            super(rotationStep, rotationStepMax, grid2, startX, startY,color, display, clear_right, clear_left);
            }
        
}
