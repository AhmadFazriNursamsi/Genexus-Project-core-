package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class GxFullTextSearchReindexer
{
   public static int Reindex( int remoteHandle )
   {
      GxSilentTrnSdt obj;
      IGxSilentTrn trn;
      boolean result;
      obj = new com.kbbaru.SdtTrips(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.kbbaru.SdtCountry(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.kbbaru.SdtCategory(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      return 1 ;
   }

}

