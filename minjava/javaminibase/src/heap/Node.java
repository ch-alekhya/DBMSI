package heap;


import global.AttrType;
import global.NID;

import java.io.IOException;

public class Node extends Tuple {

    NID nid = new NID();

    private AttrType Label = new AttrType(0);
    private AttrType Descriptor = new AttrType(5);

    public AttrType getLabel() {
        return Label;
    }

    public void setLabel(AttrType label) {
        Label = label;
    }

    public AttrType getDesc() {
        return Descriptor;
    }

    public void setDesc(AttrType descriptor) {
        Descriptor = descriptor;
    }

    public Node() {
        // Create a new node
        super();
        //set label n descriptor
    }
    
    public Node(int size) {
        // Create a new node
        super(size);
        //set label n descriptor
    }

    public Node(byte[] anode, int offset, int length) {
        super(anode, offset, length);
        //set label n descriptor
    }

    public Node(Node fromNode) {
        super(fromNode);
        //set label n descriptor
    }
    
    //come back to this.
    byte[] getNodeByteArray() {
        return super.getTupleByteArray();
    }

    public void print() throws IOException {
        AttrType type[] = {new AttrType(0), new AttrType(5)};
        super.print(type);

    }
    
    public String stringRep() throws IOException {
        AttrType type[] = {new AttrType(0), new AttrType(5)};
        return super.stringRep(type);
    }    
    
    public short size() {
        return super.size();
    }

    public void nodeCopy(Node fromNode) {
        super.tupleCopy(fromNode);
    }

    void nodeInit(byte[] anode, int offset, int length ) {
        super.tupleInit(anode, offset, length);
    }

    void nodeSet(byte[] fromNode, int offset, int length) {
        super.tupleSet(fromNode, offset, length);
    }

    public NID getNID(){
        return nid;
    }

    /**
     * setHdr will set the header of this tuple.
     *
     * @throws IOException               I/O errors
     * @throws InvalidTypeException      Invalid tupe type
     * @throws InvalidTupleSizeException Tuple size too big
     * @param    numFlds     number of fields
     * @param    types[]     contains the types that will be in this tuple
     * @param    strSizes[] contains the sizes of the string
     */

    public void setHdr(short strSizes[])
            throws IOException, InvalidTypeException, InvalidTupleSizeException {
        AttrType type[] = {new AttrType(0), new AttrType(5)};
        super.setHdr((short) 2, type, strSizes);
    }


}
