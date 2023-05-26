package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.viewattractions", "/com.kbbaru.viewattractions"})
public final  class viewattractions extends GXWebObjectStub
{
   public viewattractions( )
   {
   }

   public viewattractions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( viewattractions.class ));
   }

   public viewattractions( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new viewattractions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new viewattractions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "View Attractions";
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

