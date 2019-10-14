# OmdbApp
This App uses the Model-View-Presenter architecture to show episode listings of the first seasons of 3 TV series with information obtained from the OMDB API. Information is shown in CardViews with Poster image and Title within each corresponding Recycler View for each series. 
When an episode listing is clicked on, the user is taken to a Detail Activity with more information on the Title, Plot, Director, Writer and larger Poster image for that episode.
Sorting Methods to sort by Rating (Highest to Lowest), Title (Alphabetically) and Episode Number (Chronological) are also available. 

Some libraries used for this app are RxJava2 for network mapping, Picasso for images, CardViews and RecyclerViews for episode listings.
