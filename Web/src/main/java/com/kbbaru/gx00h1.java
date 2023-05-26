package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.gx00h1", "/com.kbbaru.gx00h1"})
public final  class gx00h1 extends GXWebObjectStub
{
   public gx00h1( )
   {
   }

   public gx00h1( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gx00h1.class ));
   }

   public gx00h1( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gx00h1_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gx00h1_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selection List Kecamatan";
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

