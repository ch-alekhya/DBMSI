package nodeheap;

import global.*;
import heap.InvalidTupleSizeException;
import heap.Node;
import heap.Tuple;

import java.io.*;


public class NodeDataPageInfo implements GlobalConst{


	  /** HFPage returns int for avail space, so we use int here */
	  int    availspace; 
	  
	  /** for efficient implementation of getRecCnt() */
	  int    recct;    
	  
	  /** obvious: id of this particular data page (a HFPage) */
	  public PageId pageId = new PageId();   
	    
	  /** auxiliary fields of DataPageInfo */

	  public static final int size = 12;// size of DataPageInfo object in bytes

	  private byte [] data;  // a data buffer
	  
	  private int offset;
	  
	  
	  public NodeDataPageInfo()
	  {  
	    data = new byte[12]; // size of datapageinfo
	    int availspace = 0;
	    recct =0;
	    pageId.pid = INVALID_PAGE;
	    offset = 0;
	  }
	  
	  
	  public NodeDataPageInfo(byte[] array)
	  {
	    data = array;
	    offset = 0;
	  }

	      
	   public byte [] returnByteArray()
	   {
	     return data;
	   }
	 
	   public NodeDataPageInfo(Node _atuple)
		       throws InvalidTupleSizeException, IOException
		  {   
		     // need check _atuple size == this.size ?otherwise, throw new exception
		    if (_atuple.getLength()!=12){
		      throw new InvalidTupleSizeException(null, "NODEHEAPFILE: TUPLE SIZE ERROR");
		    }

		    else{
		      data = _atuple.returnTupleByteArray();
		      offset = _atuple.getOffset();
		      
		      availspace = Convert.getIntValue(offset, data);
		      recct = Convert.getIntValue(offset+4, data);
		      pageId = new PageId();
		      pageId.pid = Convert.getIntValue(offset+8, data);
		      
		    }
		  }
	  
	   
	   public Node convertToNode()
		       throws IOException
		  {

		    // 1) write availspace, recct, pageId into data []
		    Convert.setIntValue(availspace, offset, data);
		    Convert.setIntValue(recct, offset+4, data);
		    Convert.setIntValue(pageId.pid, offset+8, data);


		    // 2) creat a Tuple object using this array
		    Node atuple = new Node(data, offset, size); 
		 
		    // 3) return tuple object
		    return atuple;

		  }
	   
	   public void flushToTuple() throws IOException
	   {
	      // write availspace, recct, pageId into "data[]"
	     Convert.setIntValue(availspace, offset, data);
	     Convert.setIntValue(recct, offset+4, data);
	     Convert.setIntValue(pageId.pid, offset+8, data);

	     // here we assume data[] already points to buffer pool
	   
	   }
}