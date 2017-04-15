package global;

public class NID extends RID {
	
	AttrType label= new AttrType(0);
	AttrType Derscriptor=new AttrType(5);
	
	public int slotNo;
	  public PageId pageNo = new PageId();
	  
	
	
	public NID()
	{
		super();
	}
	
	public NID (PageId pageno, int slotno)
    {
      this.pageNo = pageno;
      this.slotNo = slotno;
    }
	
	 public void copyNid (NID nid)
	    {
	      pageNo = nid.pageNo;
	      slotNo = nid.slotNo;
	    }
	 
	 
	 public void writeToByteArray(byte [] ary, int offset)
			    throws java.io.IOException
			    {
			      Convert.setIntValue ( slotNo, offset, ary);
			      Convert.setIntValue ( pageNo.pid, offset+4, ary);
			    }
			  
			  
			  /** Compares two NID object, i.e, this to the rid
			   * @param rid RID object to be compared to
			   * @return true is they are equal
			   *         false if not.
			   */
			  public boolean equals(NID nid) {
			    
			    if ((this.pageNo.pid==nid.pageNo.pid)
				&&(this.slotNo==nid.slotNo))
			      return true;
			    else
			      return false;
			  }
	 

}
