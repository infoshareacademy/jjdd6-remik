package com.infoshare.jjdd6.moviespotter.oAuth2;

public class CallbackServlet {
    //    public class CalendarServletCallbackSample extends AbstractAuthorizationCodeCallbackServlet {
//
//        @Override
//        protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
//                throws ServletException, IOException {
//            resp.sendRedirect("/");
//        }
//
//        @Override
//        protected void onError(
//                HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
//                throws ServletException, IOException {
//            // handle error
//        }
//
//        @Override
//        protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
//            GenericUrl url = new GenericUrl(req.getRequestURL().toString());
//            url.setRawPath("/oauth2callback");
//            return url.build();
//        }
//
//        @Override
//        protected AuthorizationCodeFlow initializeFlow() throws IOException {
//            return new GoogleAuthorizationCodeFlow.Builder(
//                    new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
//                    "[[ENTER YOUR CLIENT ID]]", "[[ENTER YOUR CLIENT SECRET]]",
//                    Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(
//                    DATA_STORE_FACTORY).setAccessType("offline").build();
//        }
//
//        @Override
//        protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
//            // return user ID
//            return "1";
//        }
//    }
//
//

}
