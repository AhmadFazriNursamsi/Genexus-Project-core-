package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.categoryattractionswc", "/com.kbbaru.categoryattractionswc"})
public final  class categoryattractionswc extends GXWebObjectStub
{
   public categoryattractionswc( )
   {
   }

   public categoryattractionswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoryattractionswc.class ));
   }

   public categoryattractionswc( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoryattractionswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoryattractionswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Category Attractions WC";
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

