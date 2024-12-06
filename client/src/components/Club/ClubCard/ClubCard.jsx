import React from 'react';
import ClubStats from './ClubStats';
import ClubOwner from './ClubOwner';
import ClubCategory from './ClubCategory';
import ClubVisibility from './ClubVisibility';


export default function ClubCard({ club }) {
  return (
    <article className="bg-gray-900 rounded-xl overflow-hidden border border-gray-800 hover:border-blue-500/50 transition-all duration-300 group">
      <div className="relative h-48 sm:h-56 overflow-hidden">
        <img
          src={club.imageUrl}
          alt={club.name}
          className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-300"
        />
        <div className="absolute inset-0 bg-gradient-to-t from-gray-900 via-gray-900/50 to-transparent" />
        
        <div className="absolute top-4 right-4">
          <ClubVisibility isPublic={club.public} />
        </div>
        
        <div className="absolute bottom-4 left-4 right-4 space-y-1">
          <ClubCategory category={club.category} />
          <h3 className="text-xl py-2 font-semibold text-white truncate">{club.name}</h3>
          <ClubOwner
            ownerUsername={club.ownerUsername}
            ownerImageUrl={club.ownerImageUrl}
          />
        </div>
      </div>
      
      <div className="p-4 space-y-4">
        <p className="text-gray-400 text-sm line-clamp-2">{club.description}</p>
        <ClubStats
          membersCount={club.membersCount}
          postsCount={club.postsCount}
          createdAt={club.createdAt}
        />
      </div>
    </article>
  );
}