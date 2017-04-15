package global;

public class EID extends RID {
	
	public EID()
	{
		super();
	}
	
	public EID (PageId pageno, int slotno)
    {
      this.pageNo = pageno;
      this.slotNo = slotno;
    }
	
	 public void copyEid (EID eid)
	    {
	      pageNo = eid.pageNo;
	      slotNo = eid.slotNo;
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
			  public boolean equals(EID eid) {
			    
			    if ((this.pageNo.pid==eid.pageNo.pid)
				&&(this.slotNo==eid.slotNo))
			      return true;
			    else
			      return false;
			  }

}
