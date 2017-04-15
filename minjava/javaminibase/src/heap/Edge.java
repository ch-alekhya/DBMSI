package heap;

import java.io.IOException;

import global.AttrType;
import global.EID;
import global.NID;

public class Edge  extends Tuple{
	
	AttrType Label =new AttrType(0);
	AttrType Weight =new AttrType(1);
	NID source=new NID();
	NID destination =new NID();
	EID eid =new EID();
	
	
	 public AttrType getLabel() {
	        return this.Label;
	    }

	    public void setLabel(AttrType label) {
	        this.Label = label;
	    }

	    public AttrType getWeight() {
	        return this.Weight;
	    }

	    public void setDesc(AttrType Weight) {
	        this.Weight = Weight;
	    }
	    
	    public void setSource(NID source)
	    {
	    	this.source=source;
	    }
	    
	    public NID getSource()
	    {
	    	return this.source;
	    }
	    
	    public NID getDest()
	    {
	    	return this.destination;
	    }
	    
	    public void setDest(NID dest)
	    {
	    	this.destination=dest;
	    }
	    
	    
	    public Edge() {
	        // Create a new edge
	        super();
	        //set label n descriptor
	    }
	    
	    public Edge(int size) {
	        // Create a new node
	        super(size);
	        //set label n descriptor
	    }
	    public Edge(byte[] atuple, int offset, int length) {
			super(atuple, offset, length);
		}
	    
	    public byte[] getEdgeByteArray() {
	        return super.getTupleByteArray();
	    }
	
	    public void print() throws IOException {
	        AttrType type[] = {new AttrType(1), new AttrType(1), new AttrType(1), new AttrType(1), new AttrType(0),
					new AttrType(5)};
	        super.print(type);

	    }
	    
	    public short size() {
	        return super.size();
	    }

	    public void edgeCopy(Edge fromEdge) {
	        super.tupleCopy(fromEdge);
	    }

	    void edgeInit(byte[] anode, int offset, int length ) {
	        super.tupleInit(anode, offset, length);
	    }

	    void edgeSet(byte[] fromNode, int offset, int length) {
	        super.tupleSet(fromNode, offset, length);
	    }

	    public EID getEID(){
	        return this.eid;
	    }
	    public void setHdr(short strSizes[]) throws IOException, InvalidTypeException, InvalidTupleSizeException {
			AttrType type[] = { new AttrType(1), new AttrType(1), new AttrType(1), new AttrType(1), new AttrType(0),
					new AttrType(1) };
			super.setHdr((short) 6, type, strSizes);
		}
}
