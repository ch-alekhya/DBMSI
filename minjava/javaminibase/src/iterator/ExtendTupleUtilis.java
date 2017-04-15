package iterator;

import global.AttrType;
import global.Descriptor;
import heap.FieldNumberOutOfBoundException;
import heap.Tuple;

import java.io.IOException;

/**
 * @author acheruvu
 *         this is for Task 5
 */

public class ExtendTupleUtilis extends TupleUtils {

    public static int CompareTupleWithTuple(AttrType fldType, Tuple t1, int t1_fld_no, Tuple t2, int t2_fld_no, double distance, Descriptor target)
            throws IOException, UnknowAttrType, TupleUtilsException {
        int t1_i, t2_i;
        float t1_r, t2_r;
        String t1_s, t2_s;
        Descriptor t1_des, t2_des;

        switch (fldType.attrType) {
            case AttrType.attrInteger: // Compare two integers.
                try {
                    t1_i = t1.getIntFld(t1_fld_no);
                    t2_i = t2.getIntFld(t2_fld_no);
                } catch (FieldNumberOutOfBoundException e) {
                    throw new TupleUtilsException(e, "FieldNumberOutOfBoundException is caught by TupleUtils.java");
                }
                if (t1_i == t2_i)
                    return 0;
                if (t1_i < t2_i)
                    return -1;
                if (t1_i > t2_i)
                    return 1;

            case AttrType.attrReal: // Compare two floats
                try {
                    t1_r = t1.getFloFld(t1_fld_no);
                    t2_r = t2.getFloFld(t2_fld_no);
                } catch (FieldNumberOutOfBoundException e) {
                    throw new TupleUtilsException(e, "FieldNumberOutOfBoundException is caught by TupleUtils.java");
                }
                if (t1_r == t2_r)
                    return 0;
                if (t1_r < t2_r)
                    return -1;
                if (t1_r > t2_r)
                    return 1;

            case AttrType.attrString: // Compare two strings
                try {
                    t1_s = t1.getStrFld(t1_fld_no);
                    t2_s = t2.getStrFld(t2_fld_no);
                } catch (FieldNumberOutOfBoundException e) {
                    throw new TupleUtilsException(e, "FieldNumberOutOfBoundException is caught by TupleUtils.java");
                }

                // Now handle the special case that is posed by the max_values for
                // strings...
                if (t1_s.compareTo(t2_s) > 0)
                    return 1;
                if (t1_s.compareTo(t2_s) < 0)
                    return -1;
                return 0;

            case AttrType.attrDesc: // Compare two descriptors
                try {
                    t1_des = t1.getDescFld(t1_fld_no);
                    t2_des = t2.getDescFld(t2_fld_no);
                } catch (FieldNumberOutOfBoundException e) {
                    throw new TupleUtilsException(e, "FieldNumberOutOfBoundException is caught by TupleUtils.java");
                }

                boolean status = true;
                int i = 0;

                for (i = 0; i < 5; i++) {
                    if ((int) target.value[i] != -1) {
                        status = false;
                        break;
                    }
                }
                double dist_value = t1_des.distance(t2_des);

                if (status && i == 5) {
                    if (dist_value <= distance) {
                        return 0;
                    } else {
                        return 1;
                    }

                } else {
                    double dis_des_1 = t1_des.distance(target);
                    double dis_des_2 = t2_des.distance(target);

                    if (dis_des_1 == dis_des_2) {
                        return 0;
                    } else if (dis_des_1 < dis_des_2) {
                        return 1;
                    } else {
                        return -1;
                    }

                }


            default:

                throw new UnknowAttrType(null, "Don't know how to handle attrSymbol, attrNull");

        }
    }


    /**
     * This function  compares  tuple1 with another tuple2 whose
     * field number is same as the tuple1
     *
     * @param fldType   the type of the field being compared.
     * @param t1        one tuple
     * @param value     another tuple.
     * @param t1_fld_no the field numbers in the tuples to be compared.
     * @return 0        if the two are equal,
     * 1        if the tuple is greater,
     * -1        if the tuple is smaller,
     * @throws UnknowAttrType      don't know the attribute type
     * @throws IOException         some I/O fault
     * @throws TupleUtilsException exception from this class
     */
    public static int CompareTupleWithValue(AttrType fldType,
                                            Tuple t1, int t1_fld_no,
                                            Tuple value, double distance, Descriptor target)
            throws IOException,
            UnknowAttrType,
            TupleUtilsException {
        return CompareTupleWithTuple(fldType, t1, t1_fld_no, t1, t1_fld_no, distance, target);
    }


    /**
     * This function Compares two Tuple inn all fields
     *
     * @param t1     the first tuple
     * @param t2     the secocnd tuple
     * @param type[] the field types
     * @param len    the field numbers
     * @return 0        if the two are not equal,
     * 1        if the two are equal,
     * @throws UnknowAttrType      don't know the attribute type
     * @throws IOException         some I/O fault
     * @throws TupleUtilsException exception from this class
     */

    public static int Equal(Tuple t1, Tuple t2, AttrType types[], int len, double distance, Descriptor target)
            throws IOException, UnknowAttrType, TupleUtilsException {
        int i;

        if (CompareTupleWithTuple(types[len - 1], t1, 4, t2, len - 1, distance, target) == 0)
            return 1;
        return 0;
    }
}

