package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.attractions", "/com.kbbaru.attractions"})
public final  class attractions extends GXWebObjectStub
{
   public attractions( )
   {
   }

   public attractions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( attractions.class ));
   }

   public attractions( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new attractions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new attractions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Attractions";
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

