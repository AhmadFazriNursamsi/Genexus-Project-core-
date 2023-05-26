package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.wwattractions", "/com.kbbaru.wwattractions"})
public final  class wwattractions extends GXWebObjectStub
{
   public wwattractions( )
   {
   }

   public wwattractions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwattractions.class ));
   }

   public wwattractions( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwattractions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwattractions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Work With Attractions";
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

