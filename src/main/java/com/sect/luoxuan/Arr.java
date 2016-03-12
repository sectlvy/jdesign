package com.sect.luoxuan;
import java.lang.String;

class Point {
    private int x = 0;
    private int y = 0;
    Point(int pX, int pY) {
        setPoint(pX, pY);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setPoint(int pX, int pY) {
        x = pX;
        y = pY;
    }
    public Point moveBy(int mX, int mY) {
        setPoint( (x + mX),(y + mY) );
        return this;
    }
    public Point moveBy(Point moveValue) {
        //return new Point( (this.getX()+moveValue.getX()), (this.getY()+moveValue.getY()) );
        this.setPoint( (this.getX()+moveValue.getX()), (this.getY()+moveValue.getY()) );
        return this;
    }
}

class Method extends Point {
    private static int x = 0;
    private static int y = 0;
    private final int N;//x.limit;
    private final int M;//y.limit;
    private static final Point moveLeft   = new Point(-1, 0);
    private static final Point moveRight  = new Point( 1, 0);
    private static final Point moveUp     = new Point( 0,-1);
    private static final Point moveDown   = new Point( 0, 1);

    Method(int pX, int pY) {
        super(0,0);
        setPoint(0,0);
        N = pX;
        M = pY;
    }
    public Point nextPoint(Point currentPoint) {
        int nIndex=-1,        //��ǰԪ������Ȧ(���⵽��)��Ҳ��������ֵ����Сֵ+1
            gapXs=0,        //������Ȧ���x�Ĳ�ֵ
            gapXe=0,        //������Ȧ�յ�x�Ĳ�ֵ
            gapYs=0,        //������Ȧ���y�Ĳ�ֵ
            gapYe=0;        //������Ȧ�յ�y�Ĳ�ֵ
        boolean bLeft        = false,
                bRight        = false,
                bTop        = false,
                bBottom        = false;
        Point moveWhere = new Point(0,0);

        gapXs = currentPoint.getX() - 0;
        gapXe = N - currentPoint.getX();
        gapYs = currentPoint.getY() - 0;
        gapYe = M - currentPoint.getY();

        do {
            bLeft   = gapXs>(nIndex+1)?false:true;
            bRight  = gapXe>(nIndex+1)?false:true;
            bTop    = gapYs>(nIndex+1)?false:true;
            bBottom = gapYe>(nIndex+1)?false:true;
            nIndex++;//��-1��ʼ��++
        }while( !(bLeft||bRight||bTop||bBottom) );

        //˳ʱ������,�ж��Ⱥ�Ϊ:bTop -> bRight -> bBottom -> bLeft;
        //��ʱ������,�ж��Ⱥ�Ϊ:bTop <- bRight <- bBottom <- bLeft;
        if( bTop ) {                                //����
            if( bRight )                                //���Ͻ�,����
                moveWhere = moveDown;
            else                                        //�ϱ�,����
                moveWhere = moveRight;
        }
        else if( bRight ) {                        //����
            if( bBottom )                                //���½�,����
                moveWhere = moveLeft;
            else
                moveWhere = moveDown;                        //�ұ�,����
        }
        else if( bBottom ) {                        //����
            if( bLeft )                                        //���½�:����
                if( (currentPoint.getY()-nIndex)==1 )                //��Ȧ�ֻؽ���,��������
                    moveWhere = moveRight;
                else                                                //���½�,���ƶ�
                    moveWhere = moveUp;
            else
                moveWhere = moveLeft;                        //�±�,����
        }
        else {                                        //����
            if( (currentPoint.getY()-nIndex)>=2 )        //���,����
                moveWhere = moveUp;
            else                                        //��ֵΪ1ʱ,��Ȧ�ֻؽ���
                moveWhere = moveRight;
        }
        return currentPoint.moveBy(moveWhere);        //����currentPoint����(�Ѿ�����),
    }
}

public class Arr {

    public static void main(String [] args) {

        final int DEF_ARR_N = 7;
        final int DEF_ARR_M = 7;
        int arrX = 0;
        int arrY = 0;

        int nNumArgs = args.length;
        if( nNumArgs >=2 ) {
            arrX = Integer.parseInt(args[0]);
            arrY = Integer.parseInt(args[1]);
        }
        else {
            arrX = DEF_ARR_N;
            arrY = DEF_ARR_M;
        }

        int nVal    = 0;
        int [][] aa = new int[arrY][arrX];
        Point  test = new Point(0,0);
        Method meth = new Method(arrX-1,arrY-1);

        System.out.println("start-------------------------------------------");
        for(int i=1; i<=arrX*arrY; i++) {
        //  System.out.println("aa["+(test.getY())+"]["+(test.getX())+"]="+i);
            aa[test.getY()][test.getX()] = i;
            test = meth.nextPoint(test);
        }

        String printStr;
        for(int i=0; i<arrY; i++) {
            System.out.print("        ");
            for(int j=0; j<arrX; j++) {
                printStr = ("       "+aa[i][j]);
                System.out.print(   printStr.substring( (printStr.length()-7), printStr.length() )   );
            }
            System.out.println("");
        }
    }
}

