package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.gx0050", "/com.kbbaru.gx0050"})
public final  class gx0050 extends GXWebObjectStub
{
   public gx0050( )
   {
   }

   public gx0050( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gx0050.class ));
   }

   public gx0050( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gx0050_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gx0050_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selection List Attractions";
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

