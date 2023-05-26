package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.gx00g1", "/com.kbbaru.gx00g1"})
public final  class gx00g1 extends GXWebObjectStub
{
   public gx00g1( )
   {
   }

   public gx00g1( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gx00g1.class ));
   }

   public gx00g1( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gx00g1_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gx00g1_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selection List Attrations";
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

