package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.aattractionlist", "/com.kbbaru.aattractionlist"})
public final  class aattractionlist extends GXWebObjectStub
{
   public aattractionlist( )
   {
   }

   public aattractionlist( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( aattractionlist.class ));
   }

   public aattractionlist( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new aattractionlist_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new aattractionlist_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Attraction List";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

