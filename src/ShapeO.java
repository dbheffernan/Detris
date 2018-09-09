

import java.awt.*;

public class ShapeO extends Tetromino {
        public static final int rotationStep = 0;
        public static final int rotationStepMax = 0;
        public static final int[][][] grid2 = {{{1,1,0,0},
                                                {1,1,0,0},
                                                {0,0,0,0},
                                                {0,0,0,0}}};
                                    
        public static final int startX = 100;
        public static final int startY = 40;
        public static final int clear_right = 0;
        public static final int clear_left = 0;       
        public static final int color = 5;
        public static final Color display = Color.YELLOW;
        
        public ShapeO() {
            super(rotationStep, rotationStepMax, grid2, startX, startY,color, display, clear_right, clear_left);
            }
}
